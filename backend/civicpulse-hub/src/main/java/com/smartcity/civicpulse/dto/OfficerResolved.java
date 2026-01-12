package com.smartcity.civicpulse.dto;

import com.smartcity.civicpulse.enums.ComplaintStatus;
import org.springframework.web.multipart.MultipartFile;

public class OfficerResolved {
        private Long id;
        private String address;
        private String description;
        private ComplaintStatus status;
        private Long rating;
        private String feedback;

    public  OfficerResolved(Long id,
                            String address,
                            String description,
                            ComplaintStatus status,
                            Long rating,
                            String feedback)
    {
        this.id = id;
        this.address = address;
        this.description = description;
        this.status = status;
        this.rating=rating;
        this.feedback=feedback;
    }

    public Long getRating() {
        return rating;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setRating(Long rating) {
        this.rating = rating;
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

    public ComplaintStatus getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}


