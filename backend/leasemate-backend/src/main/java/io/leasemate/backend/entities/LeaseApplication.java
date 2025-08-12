package io.leasemate.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "lease_applications")
public class LeaseApplication {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Links to user applying & apartment they want
  @Column(nullable = false)
  private String clerkUserId;

  @Column(nullable = false)
  private Long apartmentId;

  // Manages the application's status
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ApplicationStatus status = ApplicationStatus.PENDING;

  // --- I. Personal & Contact Information ---
  @Column(nullable = false)
  private String applicantFullName;

  @Column(nullable = false)
  private String applicantEmail;

  @Column(nullable = false)
  private String applicantPhoneNumber;

  private String emergencyContactName;
  private String emergencyContactPhone;

  // --- II. Occupancy Details ---
  private int totalOccupants;

  // --- III. Rental History ---
  private String previousAddress;
  private String reasonForLeaving;
  private String previousLandlordName;
  private String previousLandlordPhone;

  // --- IV. Employment & Financial ---
  private String employerName;
  private String employmentStatus;
  private String occupation;
  private double monthlyIncome;

  // --- V. Animals ---
  private boolean hasPets;
  private boolean hasServiceAnimals;

  // --- VI. Vehicle & Parking ---
  private int vehicleCount;

  // Enum for the status
  public enum ApplicationStatus {
    PENDING,
    APPROVED,
    REJECTED
  }

  // 'Default' Constructor
  public LeaseApplication() {
  }

  // Constructor
  public LeaseApplication(
      String clerkUserId, Long apartmentId,
      String applicantFullName, String applicantEmail,
      String applicantPhoneNumber, String emergencyContactName,
      String emergencyContactPhone, int totalOccupants,
      String previousAddress, String reasonForLeaving,
      String previousLandlordName, String previousLandlordPhone,
      String employerName, String employmentStatus, String occupation,
      double monthlyIncome, boolean hasPets,
      boolean hasServiceAnimals, int vehicleCount) {
    this.clerkUserId = clerkUserId;
    this.apartmentId = apartmentId;
    this.applicantFullName = applicantFullName;
    this.applicantEmail = applicantEmail;
    this.applicantPhoneNumber = applicantPhoneNumber;
    this.emergencyContactName = emergencyContactName;
    this.emergencyContactPhone = emergencyContactPhone;
    this.totalOccupants = totalOccupants;
    this.previousAddress = previousAddress;
    this.reasonForLeaving = reasonForLeaving;
    this.previousLandlordName = previousLandlordName;
    this.previousLandlordPhone = previousLandlordPhone;
    this.employerName = employerName;
    this.employmentStatus = employmentStatus;
    this.occupation = occupation;
    this.monthlyIncome = monthlyIncome;
    this.hasPets = hasPets;
    this.hasServiceAnimals = hasServiceAnimals;
    this.vehicleCount = vehicleCount;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getClerkUserId() {
    return clerkUserId;
  }

  public void setClerkUserId(String clerkUserId) {
    this.clerkUserId = clerkUserId;
  }

  public Long getApartmentId() {
    return apartmentId;
  }

  public void setApartmentId(Long apartmentId) {
    this.apartmentId = apartmentId;
  }

  public ApplicationStatus getStatus() {
    return status;
  }

  public void setStatus(ApplicationStatus status) {
    this.status = status;
  }

  public String getApplicantFullName() {
    return applicantFullName;
  }

  public void setApplicantFullName(String applicantFullName) {
    this.applicantFullName = applicantFullName;
  }

  public String getApplicantEmail() {
    return applicantEmail;
  }

  public void setApplicantEmail(String applicantEmail) {
    this.applicantEmail = applicantEmail;
  }

  public String getApplicantPhoneNumber() {
    return applicantPhoneNumber;
  }

  public void setApplicantPhoneNumber(String applicantPhoneNumber) {
    this.applicantPhoneNumber = applicantPhoneNumber;
  }

  public String getEmergencyContactName() {
    return emergencyContactName;
  }

  public void setEmergencyContactName(String emergencyContactName) {
    this.emergencyContactName = emergencyContactName;
  }

  public String getEmergencyContactPhone() {
    return emergencyContactPhone;
  }

  public void setEmergencyContactPhone(String emergencyContactPhone) {
    this.emergencyContactPhone = emergencyContactPhone;
  }

  public int getTotalOccupants() {
    return totalOccupants;
  }

  public void setTotalOccupants(int totalOccupants) {
    this.totalOccupants = totalOccupants;
  }

  public String getPreviousAddress() {
    return previousAddress;
  }

  public void setPreviousAddress(String previousAddress) {
    this.previousAddress = previousAddress;
  }

  public String getReasonForLeaving() {
    return reasonForLeaving;
  }

  public void setReasonForLeaving(String reasonForLeaving) {
    this.reasonForLeaving = reasonForLeaving;
  }

  public String getPreviousLandlordName() {
    return previousLandlordName;
  }

  public void setPreviousLandlordName(String previousLandlordName) {
    this.previousLandlordName = previousLandlordName;
  }

  public String getPreviousLandlordPhone() {
    return previousLandlordPhone;
  }

  public void setPreviousLandlordPhone(String previousLandlordPhone) {
    this.previousLandlordPhone = previousLandlordPhone;
  }

  public String getEmployerName() {
    return employerName;
  }

  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  public String getEmploymentStatus() {
    return employmentStatus;
  }

  public void setEmploymentStatus(String employmentStatus) {
    this.employmentStatus = employmentStatus;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public double getMonthlyIncome() {
    return monthlyIncome;
  }

  public void setMonthlyIncome(double monthlyIncome) {
    this.monthlyIncome = monthlyIncome;
  }

  public boolean isHasPets() {
    return hasPets;
  }

  public void setHasPets(boolean hasPets) {
    this.hasPets = hasPets;
  }

  public boolean isHasServiceAnimals() {
    return hasServiceAnimals;
  }

  public void setHasServiceAnimals(boolean hasServiceAnimals) {
    this.hasServiceAnimals = hasServiceAnimals;
  }

  public int getVehicleCount() {
    return vehicleCount;
  }

  public void setVehicleCount(int vehicleCount) {
    this.vehicleCount = vehicleCount;
  }
}
