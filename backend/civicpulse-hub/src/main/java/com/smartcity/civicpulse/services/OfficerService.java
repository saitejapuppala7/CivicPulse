package com.smartcity.civicpulse.services;

import com.smartcity.civicpulse.dto.AllComplaints;
import com.smartcity.civicpulse.dto.ComplaintByIdDto;
import com.smartcity.civicpulse.dto.ComplaintDto;
import com.smartcity.civicpulse.dto.ResolvedComplaintDto;
import com.smartcity.civicpulse.entity.Complaint;
import com.smartcity.civicpulse.entity.Department;
import com.smartcity.civicpulse.entity.Officer;
import com.smartcity.civicpulse.enums.ComplaintStatus;
import com.smartcity.civicpulse.repository.ComplaintRepository;
import com.smartcity.civicpulse.repository.OfficerRepository;
import com.smartcity.civicpulse.security.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OfficerService {
    public JwtService jwtService;
    public OfficerRepository officerRepository;
    public ComplaintRepository complaintRepository;

    public OfficerService(JwtService jwtService,OfficerRepository officerRepository,ComplaintRepository complaintRepository)
    {
        this.jwtService=jwtService;
        this.officerRepository=officerRepository;
        this.complaintRepository=complaintRepository;
    }
    public List<AllComplaints> getComplaints(String token)
    {
        String email=jwtService.extractEmail(token);
        Officer officer=officerRepository.findByEmail(email);
        Department department=officer.getDepartment();
        List<Complaint> complaints=complaintRepository.findByDepartmentAndStatus(department, ComplaintStatus.ACCEPTED);


        List<AllComplaints> allComplaints=new ArrayList<>();
        for(Complaint c:complaints)
        {
            AllComplaints all=new AllComplaints(c.getComplaintId(),c.getCitizen().getName(),
                    c.getDescription(),c.getArea(),c.getCreatedDate(),c.getStatus(), c.getImageUrl(),c.getPrioritySet());
           allComplaints.add(all);
        }
        return allComplaints;

    }
    public ComplaintByIdDto getComplaintById(Long id)
    {
        Complaint complaint = complaintRepository.findById(id).orElseThrow();
        ComplaintByIdDto complaintByIdDto=new ComplaintByIdDto(complaint.getComplaintId(),complaint.getCity(),
                complaint.getDescription(),complaint.getLatitude(),
                complaint.getLongitude(),complaint.getPrioritySet(),
                complaint.getStatus(),complaint.getImageUrl());
        return complaintByIdDto;
    }
    @Transactional
    public String resolvedComplaint(Long id, ResolvedComplaintDto resolvedComplaintDto,String token)
    {
        String email = jwtService.extractEmail(token);
        Officer officer = officerRepository.findByEmail(email);

        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        if (!complaint.getDepartment().equals(officer.getDepartment())) {
            throw new RuntimeException("You are not authorized to resolve this complaint");
        }

        if (complaint.getStatus() == ComplaintStatus.RESOLVED) {
            throw new RuntimeException("Complaint already resolved");
        }
        String imagePath = null;

        MultipartFile image = resolvedComplaintDto.getResolvedImage();

        if (image != null && !image.isEmpty()) {
            String uploadDir = System.getProperty("user.dir") + "/uploads/complaints";

            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();
            File destination = new File(directory, fileName);

            try {
                image.transferTo(destination);
            } catch (IOException e) {
                throw new RuntimeException("Failed to store image", e);
            }

            imagePath = fileName;
        }
        complaint.setResolvedDescription(resolvedComplaintDto.getResolvedDescription());
        complaint.setStatus(ComplaintStatus.RESOLVED);
        complaint.setResolvedImageUrl(imagePath);
        complaintRepository.save(complaint);

        return "Complaint Resolved";
    }


}
