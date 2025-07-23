package io.leasemate.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import io.leasemate.backend.entities.Apartment;
import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
  List<Apartment> findByBuildingId(Long buildingId);
}
