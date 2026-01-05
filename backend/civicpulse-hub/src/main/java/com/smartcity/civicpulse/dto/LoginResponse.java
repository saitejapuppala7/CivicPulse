package com.smartcity.civicpulse.dto;

public class LoginResponse {
     private boolean success;
     private String token;

    public LoginResponse(boolean success , String token)
    {
        this.success=success;
        this.token =token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
