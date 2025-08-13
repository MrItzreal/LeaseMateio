package io.leasemate.backend.dtos;

import io.leasemate.backend.entities.LeaseApplication.ApplicationStatus;

public record LeaseApplicationResponseDTO(
    Long id,
    ApplicationStatus status,

    // Apartment Info
    Long apartmentId,
    String apartmentUnitNumber,
    String buildingName,

    // Applicant Info
    String clerkUserId,
    String applicantFullName,
    String applicantEmail,
    String applicantPhoneNumber,
    String emergencyContactName,
    String emergencyContactPhone,
    int totalOccupants,
    String previousAddress,
    String reasonForLeaving,
    String previousLandlordName,
    String previousLandlordPhone,
    String employerName,
    String employmentStatus,
    String occupation,
    double monthlyIncome,
    boolean hasPets,
    boolean hasServiceAnimals,
    int vehicleCount) {
}
