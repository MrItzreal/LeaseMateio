package io.leasemate.backend.dtos;

public record BuildingRequestDTO(
    // Expected data when a building is created by management
    String name,
    String address,
    int totalGuestParkingSpots) {
}