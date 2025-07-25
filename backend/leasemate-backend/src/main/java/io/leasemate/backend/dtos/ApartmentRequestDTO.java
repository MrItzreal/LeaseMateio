package io.leasemate.backend.dtos;

public record ApartmentRequestDTO(
    String unitNumber,
    String type,
    double baseRentPrice) {
}
