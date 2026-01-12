package com.smartcity.civicpulse.controller;

import com.smartcity.civicpulse.dto.CitizenProfileResponse;
import com.smartcity.civicpulse.dto.ComplaintDto;
import com.smartcity.civicpulse.dto.Feedback;
import com.smartcity.civicpulse.dto.MyComplaints;
import com.smartcity.civicpulse.entity.Complaint;
import com.smartcity.civicpulse.services.CitizenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@PreAuthorize("hasRole('CITIZEN')")
@RequestMapping("/api/citizen")
public class CitizenController {


    public CitizenService citizenService;
   public CitizenController(CitizenService citizenService)
   {
       this.citizenService=citizenService;
   }
    @GetMapping("/profile")
    public CitizenProfileResponse  profile() {
        return citizenService.getProfile();

    }

    @PostMapping("/register-complaint")
    public String registerComplaint(@ModelAttribute ComplaintDto complaintDto , HttpServletRequest request) {
       String token=request.getHeader("Authorization").substring(7);
       return citizenService.registerComplaint(complaintDto,token);
   }
   @GetMapping("/my")
    public List<MyComplaints> getComplaints(HttpServletRequest request)
   {
       String token=request.getHeader("Authorization").substring(7);
       return citizenService.getComplaints(token);
   }
   @GetMapping("/complaint/{id}")
    public MyComplaints getComplaintsById(@PathVariable Long id)
   {
       return citizenService.getComplaintsById(id);
   }
   @PostMapping("/complaint/{id}/feedback")
    public String postFeedBack(@PathVariable Long id,@RequestBody Feedback feedback)
   {
       return citizenService.postFeedback(id,feedback);
   }





}

