package io.leasemate.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import io.leasemate.backend.dtos.BuildingRequestDTO;
import io.leasemate.backend.dtos.BuildingResponseDTO;
import io.leasemate.backend.entities.Building;
import io.leasemate.backend.repositories.BuildingRepository;

@Service
public class BuildingService {
  private final BuildingRepository buildingRepository;

  // Constructor
  public BuildingService(BuildingRepository buildingRepository) {
    this.buildingRepository = buildingRepository;
  }

  // Method: Creates new buildings.
  public BuildingResponseDTO createBuilding(BuildingRequestDTO requestDTO) {
    if (buildingRepository.findByName(requestDTO.name()).isPresent()) {
      throw new IllegalStateException("A building with this name already exists.");
    }

    Building newBuilding = new Building();
    newBuilding.setName(requestDTO.name());
    newBuilding.setAddress(requestDTO.address());
    newBuilding.setTotalGuestParkingSpots(requestDTO.totalGuestParkingSpots());
    newBuilding.setContactEmail(requestDTO.contactEmail());
    newBuilding.setContactPhoneNumber(requestDTO.contactPhoneNumber());

    Building savedBuilding = buildingRepository.save(newBuilding);
    return mapToBuildingResponseDTO(savedBuilding);
  }

  // Method: Lists all buildings.
  public List<BuildingResponseDTO> getAllBuildings() {
    return buildingRepository.findAll()
        .stream()
        .map(this::mapToBuildingResponseDTO)
        .collect(Collectors.toList());
  }

  // Method: Converts Entity to DTO.
  private BuildingResponseDTO mapToBuildingResponseDTO(Building building) {
    return new BuildingResponseDTO(
        building.getId(),
        building.getName(),
        building.getAddress(),
        building.getTotalGuestParkingSpots(),
        building.getApartments() != null ? building.getApartments().size() : 0,
        building.getContactEmail(),
        building.getContactPhoneNumber());
  }
}
