package io.leasemate.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "apartments")
public class Apartment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "unit_number", nullable = false)
  private String unitNumber;

  @Column(nullable = false)
  private String type; // We can make this an Enum later

  @Column(name = "base_rent_price", nullable = false)
  private double baseRentPrice;

  @Column(name = "is_occupied", columnDefinition = "boolean default false")
  private boolean isOccupied;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "building_id", nullable = false)
  private Building building;

  // 'Default' Constructor
  public Apartment() {
  }

  // Constructor
  public Apartment(
      String unitNumber,
      String type,
      double baseRentPrice,
      boolean isOccupied,
      Building building) {
    this.unitNumber = unitNumber;
    this.type = type;
    this.baseRentPrice = baseRentPrice;
    this.isOccupied = isOccupied;
    this.building = building;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUnitNumber() {
    return unitNumber;
  }

  public void setUnitNumber(String unitNumber) {
    this.unitNumber = unitNumber;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBaseRentPrice() {
    return baseRentPrice;
  }

  public void setBaseRentPrice(double baseRentPrice) {
    this.baseRentPrice = baseRentPrice;
  }

  public boolean isOccupied() {
    return isOccupied;
  }

  public void setOccupied(boolean isOccupied) {
    this.isOccupied = isOccupied;
  }

  public Building getBuilding() {
    return building;
  }

  public void setBuilding(Building building) {
    this.building = building;
  }

}
