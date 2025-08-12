package io.leasemate.backend.services;

import org.springframework.stereotype.Service;
import io.leasemate.backend.repositories.LeaseApplicationRepository;

@Service
public class LeaseApplicationService {
  private final LeaseApplicationRepository leaseApplicationRepository;

  // Constructor
  public LeaseApplicationService(LeaseApplicationRepository leaseApplicationRepository) {
    this.leaseApplicationRepository = leaseApplicationRepository;
  }
}
