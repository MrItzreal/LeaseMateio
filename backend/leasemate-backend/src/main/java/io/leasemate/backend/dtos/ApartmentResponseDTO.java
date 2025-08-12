package io.leasemate.backend.dtos;

public record ApartmentResponseDTO(
        // Server sends FROM itself back TO the user.
        Long id,
        String unitNumber,
        String type,
        double baseRentPrice,
        boolean isOccupied,
        Long buildingId) {
}
