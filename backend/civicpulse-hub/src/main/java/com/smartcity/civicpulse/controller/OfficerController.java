package com.smartcity.civicpulse.controller;

import com.smartcity.civicpulse.dto.*;
import com.smartcity.civicpulse.services.OfficerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@PreAuthorize("hasRole('OFFICER')")
@RequestMapping("api/officer")
public class OfficerController {
    public OfficerService officerService;

     public OfficerController(OfficerService officerService)
     {
         this.officerService=officerService;
     }


    @GetMapping("/complaints")
    public List<AllComplaints> getComplaints(HttpServletRequest request)
    {
        String token=request.getHeader("Authorization").substring(7);
        return officerService.getComplaints(token);
    }
    @GetMapping("/complaint/{id}")
    public ComplaintByIdDto getComplaintById(@PathVariable Long id) {
        return officerService.getComplaintById(id);
    }
    @PostMapping("/complaint/{id}/resolve")
    public String resolvedComplaint(@PathVariable Long id, @ModelAttribute ResolvedComplaintDto resolvedComplaintDto,HttpServletRequest request)
    {
        String token=request.getHeader("Authorization").substring(7);
        System.out.println("working");
        return officerService.resolvedComplaint(id,resolvedComplaintDto,token);
    }
    @GetMapping("/complaint/resolved")
    public List<OfficerResolved> getResolvedComplaints(HttpServletRequest request)
    {
        String token=request.getHeader("Authorization").substring(7);
        return officerService.getResolvedComplaints(token);

    }

}
