package com.smartcity.civicpulse.dto;

import com.smartcity.civicpulse.enums.ComplaintStatus;

import java.time.LocalDateTime;

public class MyComplaints {
    private Long id;
    private String category;
    private String description;
    private ComplaintStatus status;
    private LocalDateTime dateTime;
    private String department;
    private String image;
    private String resolvedImage;
    private String resolvedDescription;
    private Long rating;
    private String feedback;
     public MyComplaints(Long id, String department,String description,ComplaintStatus status,
                         LocalDateTime dateTime,String image,String resolvedImage,
                         String resolvedDescription,String feedback,Long rating)
     {
         this.id=id;
         this.department=department;
         this.dateTime=dateTime;
         this.status=status;
         this.description=description;
         this.image=image;
         this.resolvedImage=resolvedImage;
         this.resolvedDescription=resolvedDescription;
         this.rating=rating;
         this.feedback=feedback;
     }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getResolvedDescription() {
        return resolvedDescription;
    }

    public void setResolvedDescription(String resolvedDescription) {
        this.resolvedDescription = resolvedDescription;
    }

    public void setResolvedImage(String resolvedImage) {
        this.resolvedImage = resolvedImage;
    }

    public String getResolvedImage() {
        return resolvedImage;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedDate() {
        return dateTime;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setCreatedDate(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
