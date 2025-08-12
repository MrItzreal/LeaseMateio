package io.leasemate.backend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import io.leasemate.backend.entities.LeaseApplication;
import io.leasemate.backend.entities.LeaseApplication.ApplicationStatus;

public interface LeaseApplicationRepository extends JpaRepository<LeaseApplication, Long> {
  // For management portal to find PENDING, APPROVED, etc.
  List<LeaseApplication> findByStatus(ApplicationStatus status);
}
