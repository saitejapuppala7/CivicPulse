package com.smartcity.civicpulse.dto;

import com.smartcity.civicpulse.enums.ComplaintStatus;
import com.smartcity.civicpulse.enums.PrioritySet;

import java.time.LocalDateTime;

public class PendingComplaints {

    private Long id;
    private String name;
    private String description;
    private String address;
    private LocalDateTime createdAt;
    private ComplaintStatus status;
    private PrioritySet prioritySet;
    private String image;
    private String zone;
    public PendingComplaints( Long id, String name, String description, String address,
                              LocalDateTime createdAt,String image,String zone)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.address=address;
        this.createdAt=createdAt;
        this.image=image;
        this.zone=zone;

    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getZone() {
        return zone;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setPrioritySet(PrioritySet prioritySet) {
        this.prioritySet = prioritySet;
    }

    public PrioritySet getPrioritySet() {
        return prioritySet;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
