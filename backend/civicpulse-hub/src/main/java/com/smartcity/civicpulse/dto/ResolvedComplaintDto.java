package com.smartcity.civicpulse.dto;

import org.springframework.web.multipart.MultipartFile;

public class ResolvedComplaintDto {
    private String resolvedDescription;
    private MultipartFile resolvedImage;

    public void setResolvedDescription(String resolvedDescription) {
        this.resolvedDescription = resolvedDescription;
    }

    public String getResolvedDescription() {
        return resolvedDescription;
    }

    public MultipartFile getResolvedImage() {
        return resolvedImage;
    }

    public void setResolvedImage(MultipartFile resolvedImage) {
        this.resolvedImage = resolvedImage;
    }
}
