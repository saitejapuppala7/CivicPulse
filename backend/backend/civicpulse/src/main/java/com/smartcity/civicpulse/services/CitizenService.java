package com.smartcity.civicpulse.services;

import com.smartcity.civicpulse.dto.CitizenProfileResponse;
import com.smartcity.civicpulse.dto.ComplaintDto;

import com.smartcity.civicpulse.dto.MyComplaints;
import com.smartcity.civicpulse.entity.*;
import com.smartcity.civicpulse.enums.ComplaintStatus;
import com.smartcity.civicpulse.repository.*;
import com.smartcity.civicpulse.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CitizenService {

    public  JwtService jwtService;
    public  ComplaintRepository complaintRepository;

    public OfficerRepository officerRepository;

    public CitizenRepository citizenRepository;

    public DepartmentRepository departmentRepository;
    public UserRepository userRepository;
    public CitizenService(UserRepository userRepository ,JwtService jwtService, ComplaintRepository complaintRepository,OfficerRepository officerRepository,
                          CitizenRepository citizenRepository,DepartmentRepository departmentRepository) {
        this.complaintRepository = complaintRepository;
        this.officerRepository = officerRepository;
        this.jwtService=jwtService;
        this.departmentRepository=departmentRepository;
        this.citizenRepository=citizenRepository;
        this.userRepository=userRepository;
    }


    public String registerComplaint(ComplaintDto complaintDto,  String token) {
        String email = jwtService.extractEmail(token);
        Citizen citizen = citizenRepository.findByEmail(email);
        Department department = departmentRepository.findByName(complaintDto.getCategory());
        Officer officer = officerRepository.findByDepartment(department);
        Complaint complaint = new Complaint();
        complaint.setCitizen(citizen);
        complaint.setOfficer(officer);
        complaint.setDescription(complaintDto.getDescription());
        complaint.setLatitude(complaintDto.getLatitude());
        complaint.setLongitude(complaintDto.getLongitude());
        complaint.setArea(complaintDto.getArea());
        complaint.setCity(complaintDto.getCity());
        complaint.setLandmark(complaintDto.getLandmark());
        complaint.setDepartment(department);
        complaint.setCreatedDate(LocalDateTime.now());
        complaint.setStatus(ComplaintStatus.PENDING);
        complaintRepository.save(complaint);

        return "Complaint Submitted Successfully";

    }

    public CitizenProfileResponse getProfile() {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Citizen citizen = citizenRepository.findByEmail(email);

        if (citizen == null) {
            throw new RuntimeException("Citizen not found");
        }

        CitizenProfileResponse response = new CitizenProfileResponse();
        response.setName(citizen.getName());
        response.setEmail(citizen.getEmail());
        response.setMobile(citizen.getPhone());
        response.setAddress(citizen.getAddress());

        return response;
    }
    public List<MyComplaints> getComplaints(String token)
    {
        String email=jwtService.extractEmail(token);
        Citizen citizen=citizenRepository.findByEmail(email);
        List<Complaint> complaints = complaintRepository.findByCitizen(citizen);
        List<MyComplaints> result = new ArrayList<>();

        for (Complaint c : complaints) {
            MyComplaints dto = new MyComplaints(
                    c.getComplaintId(),
                    c.getDepartment().getName(),
                    c.getDescription(),
                    c.getStatus(),
                    c.getCreatedDate()

            );
            result.add(dto);
        }
        return result;
    }
}





