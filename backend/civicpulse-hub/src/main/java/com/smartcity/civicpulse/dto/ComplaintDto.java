package com.smartcity.civicpulse.dto;

import org.springframework.web.multipart.MultipartFile;

public class ComplaintDto {

    private String category;
    private String description;
    private String area;
    private String city;
    private String landmark;
    private double latitude;
    private double longitude;
    private String status;
    private MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getArea() {
        return area;
    }

    public String getCategory() {
        return category;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}
