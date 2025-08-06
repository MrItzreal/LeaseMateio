package io.leasemate.backend.dtos;

import jakarta.validation.constraints.NotEmpty;

public record BuildingRequestDTO(
        // Expected data when a building is created by management
        @NotEmpty(message = "Name should not be empty") String name,
        @NotEmpty(message = "Address should not be empty") String address,
        int totalGuestParkingSpots,
        String contactEmail,
        String contactPhoneNumber) {
}