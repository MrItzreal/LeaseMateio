package io.leasemate.backend.dtos;

public record ApartmentRequestDTO(
        // Sends this data TO the server.
        String unitNumber,
        String type,
        double baseRentPrice) {
}
