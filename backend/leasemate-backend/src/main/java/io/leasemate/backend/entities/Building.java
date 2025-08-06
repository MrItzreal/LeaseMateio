package io.leasemate.backend.entities;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "buildings")
public class Building {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String address;

  @Column(name = "total_guest_parking_spots")
  private int totalGuestParkingSpots;

  @Column(name = "contact_email")
  private String contactEmail;

  @Column(name = "contact_phone_number")
  private String contactPhoneNumber;

  @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Apartment> apartments;

  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public String getContactPhoneNumber() {
    return contactPhoneNumber;
  }

  public void setContactPhoneNumber(String contactPhoneNumber) {
    this.contactPhoneNumber = contactPhoneNumber;
  }

  // 'Default' Constructor
  public Building() {
  }

  // Constructor
  public Building(
      String name,
      String address,
      int totalGuestParkingSpots) {
    this.name = name;
    this.address = address;
    this.totalGuestParkingSpots = totalGuestParkingSpots;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getTotalGuestParkingSpots() {
    return totalGuestParkingSpots;
  }

  public void setTotalGuestParkingSpots(int totalGuestParkingSpots) {
    this.totalGuestParkingSpots = totalGuestParkingSpots;
  }

  public List<Apartment> getApartments() {
    return apartments;
  }

  public void setApartments(List<Apartment> apartments) {
    this.apartments = apartments;
  }

}
