package io.leasemate.backend.repositories;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import io.leasemate.backend.entities.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {
  // Finds building by name.
  Optional<Building> findByName(String name);
}