package com.smartcity.civicpulse.dto;

import com.smartcity.civicpulse.enums.ComplaintStatus;
import com.smartcity.civicpulse.enums.PrioritySet;

import java.time.LocalDateTime;

public class AllComplaints {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String image;
    private LocalDateTime createdAt;
    private ComplaintStatus status;
    private PrioritySet prioritySet;
    private String zone;

    public AllComplaints( Long id, String name, String description,
                          String address,LocalDateTime createdAt,
                          ComplaintStatus status,String image,PrioritySet prioritySet,String zone)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.address=address;
        this.createdAt=createdAt;
        this.status=status;
        this.image=image;
        this.prioritySet=prioritySet;
        this.zone=zone;


    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public PrioritySet getPrioritySet() {
        return prioritySet;
    }

    public void setPrioritySet(PrioritySet prioritySet) {
        this.prioritySet = prioritySet;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
