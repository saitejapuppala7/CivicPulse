package com.smartcity.civicpulse.dto;

import com.smartcity.civicpulse.enums.ComplaintStatus;

import java.time.LocalDateTime;

public class AllComplaints {
    private Long id;
    private String name;
    private String description;
    private String address;
    private LocalDateTime createdAt;
    private ComplaintStatus status;

    public AllComplaints( Long id, String name, String description, String address,LocalDateTime createdAt,ComplaintStatus status)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.address=address;
        this.createdAt=createdAt;
        this.status=status;

    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

}
