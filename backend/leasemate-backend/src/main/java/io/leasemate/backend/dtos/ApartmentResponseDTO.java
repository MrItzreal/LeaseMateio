package io.leasemate.backend.dtos;

public record ApartmentResponseDTO(
    Long id,
    String unitNumber,
    String type,
    double baseRentPrice,
    boolean isOccupied,
    Long buildingId) {
}
