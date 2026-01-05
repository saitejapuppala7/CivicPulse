package com.smartcity.civicpulse.dto;

import com.smartcity.civicpulse.enums.ComplaintStatus;
import com.smartcity.civicpulse.enums.PrioritySet;

public class ComplaintByIdDto {

        private Long id;
        private String address;
        private String description;
        private Double latitude;
        private Double longitude;
        private PrioritySet prioritySet;
        private ComplaintStatus status;
        private String image;

        public ComplaintByIdDto() {}

        public ComplaintByIdDto(
                Long id,
                String address,
                String description,
                Double latitude,
                Double longitude,
                PrioritySet prioritySet,
                ComplaintStatus status,
                String image
        ) {
            this.id = id;
            this.address = address;
            this.description = description;
            this.latitude = latitude;
            this.longitude = longitude;
            this.prioritySet = prioritySet;
            this.status = status;
            this.image = image;
        }

        public Long getId() {
            return id;
        }

        public String getAddress() {
            return address;
        }

        public String getDescription() {
            return description;
        }

        public Double getLatitude() {
            return latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

    public void setPrioritySet(PrioritySet prioritySet) {
        this.prioritySet = prioritySet;
    }

    public PrioritySet getPrioritySet() {
        return prioritySet;
    }

    public String getImage() {
            return image;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }


    public ComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public void setImage(String image) {
            this.image = image;
        }
    }


