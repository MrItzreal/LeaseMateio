package io.leasemate.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.leasemate.backend.dtos.BuildingRequestDTO;
import io.leasemate.backend.dtos.BuildingResponseDTO;
import io.leasemate.backend.services.BuildingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {

  private final BuildingService buildingService;

  public BuildingController(BuildingService buildingService) {
    this.buildingService = buildingService;
  }

  // POST
  @PostMapping
  public ResponseEntity<BuildingResponseDTO> createBuilding(
      @RequestBody BuildingRequestDTO buildingRequestDTO) {
    BuildingResponseDTO createdBuilding = buildingService.createBuilding(buildingRequestDTO);
    return new ResponseEntity<>(createdBuilding, HttpStatus.CREATED);
  }

  // GET
  @GetMapping
  public ResponseEntity<List<BuildingResponseDTO>> getAllBuildings() {
    List<BuildingResponseDTO> buildings = buildingService.getAllBuildings();
    return ResponseEntity.ok(buildings);
  }

  // PUT or PATCH
  // DELETE
}
