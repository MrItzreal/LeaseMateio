package io.leasemate.backend.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import io.leasemate.backend.dtos.LeaseApplicationResponseDTO;
import io.leasemate.backend.entities.Apartment;
import io.leasemate.backend.entities.LeaseApplication;
import io.leasemate.backend.entities.LeaseApplication.ApplicationStatus;
import io.leasemate.backend.repositories.ApartmentRepository;
import io.leasemate.backend.repositories.LeaseApplicationRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LeaseApplicationService {
  private final LeaseApplicationRepository leaseApplicationRepository;
  private final ApartmentRepository apartmentRepository;

  // Constructor
  public LeaseApplicationService(LeaseApplicationRepository leaseApplicationRepository,
      ApartmentRepository apartmentRepository) {
    this.leaseApplicationRepository = leaseApplicationRepository;
    this.apartmentRepository = apartmentRepository;
  }

  // View Applications by Status
  public List<LeaseApplicationResponseDTO> getApplicationsByStatus(ApplicationStatus status) {
    List<LeaseApplication> leaseApplications = leaseApplicationRepository.findByStatus(status);
    return leaseApplications
        .stream()
        .map(this::mapEntityToDto)
        .collect(Collectors.toList());
  }

  // Method: Converts Entity to DTO.
  private LeaseApplicationResponseDTO mapEntityToDto(LeaseApplication application) {
    Apartment apartment = apartmentRepository.findById(application.getApartmentId())
        .orElseThrow(() -> new EntityNotFoundException(
            "Apartment not found for application: " + application.getId()));

    return new LeaseApplicationResponseDTO(
        application.getId(),
        application.getStatus(),
        apartment.getId(),
        apartment.getUnitNumber(),
        apartment.getBuilding().getName(),
        application.getClerkUserId(),
        application.getApplicantFullName(),
        application.getApplicantEmail(),
        application.getApplicantPhoneNumber(),
        application.getEmergencyContactName(),
        application.getEmergencyContactPhone(),
        application.getTotalOccupants(),
        application.getPreviousAddress(),
        application.getReasonForLeaving(),
        application.getPreviousLandlordName(),
        application.getPreviousLandlordPhone(),
        application.getEmployerName(),
        application.getEmploymentStatus(),
        application.getOccupation(),
        application.getMonthlyIncome(),
        application.isHasPets(),
        application.isHasServiceAnimals(),
        application.getVehicleCount());
  }
}

// View a Single Application's Details

// Approve or Reject an Application
