package io.leasemate.backend.dtos;

import io.leasemate.backend.entities.LeaseApplication.ApplicationStatus;

public record UpdateApplicationStatusRequestDTO(ApplicationStatus status) {
}
