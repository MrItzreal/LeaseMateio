package io.leasemate.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import io.leasemate.backend.entities.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}