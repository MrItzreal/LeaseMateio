package io.leasemate.backend.dtos;

public record BuildingResponseDTO(
        // Data sent back after creating a building
        Long id,
        String name,
        String address,
        int totalGuestParkingSpots,
        int apartmentCount,
        String contactEmail,
        String contactPhoneNumber) {
}
