package com.smartcity.civicpulse.dto;

import com.smartcity.civicpulse.enums.ComplaintStatus;

import java.time.LocalDateTime;

public class PendingComplaints {

    private Long id;
    private String name;
    private String description;
    private String address;
    private LocalDateTime createdAt;
    private ComplaintStatus status;

    public PendingComplaints( Long id, String name, String description, String address,LocalDateTime createdAt)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.address=address;
        this.createdAt=createdAt;

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
