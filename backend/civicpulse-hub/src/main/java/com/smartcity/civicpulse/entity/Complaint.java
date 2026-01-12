package com.smartcity.civicpulse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartcity.civicpulse.enums.ComplaintStatus;
import com.smartcity.civicpulse.enums.PrioritySet;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;

    @ManyToOne
    @JoinColumn(name = "citizen_id", nullable = false)
    private Citizen citizen;

    @ManyToOne
    @JoinColumn(name = "officer_id", nullable = false)
    private Officer officer;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(nullable = false)
    private String description;
    @Column(nullable = true)
    private String resolvedDescription;

    @Enumerated(EnumType.STRING)
    private ComplaintStatus status;
    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private PrioritySet prioritySet;

    private double latitude;
    private double longitude;
    private String area;
    private String city;
    private String landmark;
    private String imageUrl;
    private String resolvedImageUrl;
    private Long rating;
    private String feedback;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;




    public Complaint() {
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Long getRating() {
        return rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getResolvedImageUrl() {
        return resolvedImageUrl;
    }

    public void setResolvedImageUrl(String resolvedImageUrl) {
        this.resolvedImageUrl = resolvedImageUrl;
    }


    public String getResolvedDescription() {
        return resolvedDescription;
    }

    public void setResolvedDescription(String resolvedDescription) {
        this.resolvedDescription = resolvedDescription;
    }

    public PrioritySet getPrioritySet() {
        return prioritySet;
    }

    public void setPrioritySet(PrioritySet prioritySet) {
        this.prioritySet = prioritySet;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

}
