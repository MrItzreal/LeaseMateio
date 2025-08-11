package io.leasemate.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.leasemate.backend.dtos.BuildingRequestDTO;
import io.leasemate.backend.dtos.BuildingResponseDTO;
import io.leasemate.backend.services.BuildingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/buildings")
@Tag(name = "Building API")
public class BuildingController {

  private final BuildingService buildingService;

  public BuildingController(BuildingService buildingService) {
    this.buildingService = buildingService;
  }

  // POST
  @Operation(
    summary = "Create a new building",
    description = "Creates a new building resource in the system. Requires authentication. Returns the created building details.",
    responses = {
      @ApiResponse(
        responseCode = "201",
        description = "Building created successfully"
      ),
      @ApiResponse(
        responseCode = "400",
        description = "Invalid input data"
      ),
      @ApiResponse(
        responseCode = "401",
        description = "Unauthorized or invalid token"
      ),
      @ApiResponse(
        responseCode = "409",
        description = "Building with the same name already exists"
      )
    }
  )
  @PostMapping
  public ResponseEntity<BuildingResponseDTO> createBuilding(
      @RequestBody BuildingRequestDTO buildingRequestDTO) {
    BuildingResponseDTO createdBuilding = buildingService.createBuilding(buildingRequestDTO);
    return new ResponseEntity<>(createdBuilding, HttpStatus.CREATED);
  }

  // GET
    @Operation(
    summary = "Get all buildings",
    description = "Retrieves a list of all building in the system. Requires authentication. Returns an array of building details.",
    responses = {
      @ApiResponse(
        responseCode = "200",
        description = "List of buildings retrieved successfully"
      ),
      @ApiResponse(
        responseCode = "401",
        description = "Unauthorized or invalid token"
      )
    }
  )
  @GetMapping
  public ResponseEntity<List<BuildingResponseDTO>> getAllBuildings() {
    List<BuildingResponseDTO> buildings = buildingService.getAllBuildings();
    return ResponseEntity.ok(buildings);
  }

  // PUT or PATCH
  // DELETE
}
