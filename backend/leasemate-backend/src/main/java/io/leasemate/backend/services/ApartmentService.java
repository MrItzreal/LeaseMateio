package io.leasemate.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import io.leasemate.backend.dtos.ApartmentRequestDTO;
import io.leasemate.backend.dtos.ApartmentResponseDTO;
import io.leasemate.backend.entities.Apartment;
import io.leasemate.backend.entities.Building;
import io.leasemate.backend.repositories.ApartmentRepository;
import io.leasemate.backend.repositories.BuildingRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ApartmentService {
  // Repositories
  private final ApartmentRepository apartmentRepository;
  private final BuildingRepository buildingRepository;

  // Constructor
  public ApartmentService(
      ApartmentRepository apartmentRepository,
      BuildingRepository buildingRepository) {
    this.apartmentRepository = apartmentRepository;
    this.buildingRepository = buildingRepository;
  }

  // Method: Creates new apartment.
  public ApartmentResponseDTO createApartment(Long buildingId, ApartmentRequestDTO requestDTO) {

    // Find building by id, if not, throw an exception
    Building building = buildingRepository.findById(buildingId)
        .orElseThrow(() -> new EntityNotFoundException("Building not found with id: " + buildingId));

    Apartment newApartment = new Apartment();
    newApartment.setUnitNumber(requestDTO.unitNumber());
    newApartment.setType(requestDTO.type());
    newApartment.setBaseRentPrice(requestDTO.baseRentPrice());
    newApartment.setBuilding(building);

    Apartment savedApartment = apartmentRepository.save(newApartment);
    return mapToApartmentResponseDTO(savedApartment);
  }

  // Method: Lists all apartments for specific building.
  public List<ApartmentResponseDTO> getApartmentsByBuildingId(Long buildingId) {
    // Checks if building exists
    if (!buildingRepository.existsById(buildingId)) {
      throw new EntityNotFoundException("Building not found with id: " + buildingId);
    }

    return apartmentRepository.findByBuildingId(buildingId)
        .stream()
        .map(this::mapToApartmentResponseDTO)
        .collect(Collectors.toList());
  }

  // Method: Converts Entity to DTO.
  private ApartmentResponseDTO mapToApartmentResponseDTO(Apartment apartment) {
    return new ApartmentResponseDTO(
        apartment.getId(),
        apartment.getUnitNumber(),
        apartment.getType(),
        apartment.getBaseRentPrice(),
        apartment.isOccupied(),
        apartment.getBuilding().getId());
  }
}
