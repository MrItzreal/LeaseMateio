package io.leasemate.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.leasemate.backend.dtos.ApartmentRequestDTO;
import io.leasemate.backend.dtos.ApartmentResponseDTO;
import io.leasemate.backend.services.ApartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/buildings/{buildingId}/apartments")
@Tag(name = "Apartment API")
public class ApartmentController {

  private final ApartmentService apartmentService;

  public ApartmentController(ApartmentService apartmentService) {
    this.apartmentService = apartmentService;
  }

  // POST
  @Operation(
    summary = "Creates a new apartment",
    description = "Creates a new apartment and assigns it to a specific building by id. Requires authentication. Returns the created apartment details.",
    parameters = {
      @Parameter(
        name = "buildingId",
        description = "ID of the building to assign the apartment to",
        required = true,
        example = "1"
      )
    },
    responses = {
     @ApiResponse(
        responseCode = "201",
        description = "Apartment created/assigned successfully"
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
        responseCode = "404",
        description = "Building does not exist"
      )
    }
  )
  @PostMapping
  public ResponseEntity<ApartmentResponseDTO> createApartment(
      @PathVariable Long buildingId,
      @RequestBody ApartmentRequestDTO apartmentRequestDTO) {
    ApartmentResponseDTO createdApartment = apartmentService.createApartment(buildingId, apartmentRequestDTO);
    return new ResponseEntity<>(createdApartment, HttpStatus.CREATED);
  }

  // GET
  @Operation(
    summary = "Get all apartments for a building",
    description = "Retrieves all apartments assigned to a specific building by its id.",
    parameters = {
      @Parameter(
        name = "buildingId",
        description = "ID of the building to retrieve the apartment from",
        required = true,
        example = "1"
      )
    },
    responses = {
      @ApiResponse(
        responseCode = "200",
        description = "Apartment retrieved successfully"
      ),
      @ApiResponse(
        responseCode = "401",
        description = "Unauthorized or invalid token"
      )
    }
  )
  @GetMapping
  public ResponseEntity<List<ApartmentResponseDTO>> getApartmentsByBuilding(
      @PathVariable Long buildingId) {
    List<ApartmentResponseDTO> apartments = apartmentService.getApartmentsByBuildingId(buildingId);
    return ResponseEntity.ok(apartments);
  }

}
