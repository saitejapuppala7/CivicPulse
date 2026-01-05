package com.smartcity.civicpulse.dto;

public class Registation {

   private String name;
   private String mobile_number;
   private String address;
   private String email;
   private String role="CITIZEN";
   private String password;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public String getPassword() {
        return password;
    }


    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
