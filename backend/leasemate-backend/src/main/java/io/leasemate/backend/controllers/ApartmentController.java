package io.leasemate.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.leasemate.backend.dtos.ApartmentRequestDTO;
import io.leasemate.backend.dtos.ApartmentResponseDTO;
import io.leasemate.backend.services.ApartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;

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
  @PostMapping
  public ResponseEntity<ApartmentResponseDTO> createApartment(
      @PathVariable Long buildingId,
      @RequestBody ApartmentRequestDTO apartmentRequestDTO) {
    ApartmentResponseDTO createdApartment = apartmentService.createApartment(buildingId, apartmentRequestDTO);
    return new ResponseEntity<>(createdApartment, HttpStatus.CREATED);
  }

  // GET
  @GetMapping
  public ResponseEntity<List<ApartmentResponseDTO>> getApartmentsByBuilding(
      @PathVariable Long buildingId) {
    List<ApartmentResponseDTO> apartments = apartmentService.getApartmentsByBuildingId(buildingId);
    return ResponseEntity.ok(apartments);
  }

}
