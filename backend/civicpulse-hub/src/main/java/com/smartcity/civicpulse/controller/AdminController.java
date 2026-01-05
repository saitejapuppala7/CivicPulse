package com.smartcity.civicpulse.controller;


import com.smartcity.civicpulse.dto.AllComplaints;
import com.smartcity.civicpulse.dto.PendingComplaints;
import com.smartcity.civicpulse.dto.Priority;
import com.smartcity.civicpulse.services.AdminService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/admin")
public class AdminController {

    public AdminService adminService;
    public AdminController(AdminService adminService)
    {
        this.adminService=adminService;
    }
    @GetMapping("/pending")
    public List<PendingComplaints> getPendingComplaints()
    {

        return adminService.getPendingComplaints();
    }
    @PostMapping("/{id}/accept")
    public void acceptComplaint(@PathVariable Long id, @RequestBody Priority request) {
        adminService.acceptComplaint(id,request.getPriority());
    }

    @PostMapping("/{id}/reject")
    public void rejectComplaint(@PathVariable Long id) {
        adminService.rejectComplaint(id);
    }


   @GetMapping("/all")
    public List<AllComplaints> getAllComplaints()
   {
       return adminService.getAllComplaints();
   }



}
