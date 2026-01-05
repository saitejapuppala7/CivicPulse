package com.smartcity.civicpulse.services;

import com.smartcity.civicpulse.dto.AllComplaints;
import com.smartcity.civicpulse.dto.PendingComplaints;
import com.smartcity.civicpulse.entity.Complaint;
import com.smartcity.civicpulse.enums.ComplaintStatus;
import com.smartcity.civicpulse.enums.PrioritySet;
import com.smartcity.civicpulse.repository.ComplaintRepository;
import com.smartcity.civicpulse.security.JwtService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminService {
    public JwtService jwtService;
    public ComplaintRepository complaintRepository;


    public AdminService(JwtService jwtService,ComplaintRepository complaintRepository)
    {
        this.jwtService=jwtService;
        this.complaintRepository=complaintRepository;
    }

    public List<PendingComplaints> getPendingComplaints() {


        List<Complaint> complaints = complaintRepository.findByStatus(ComplaintStatus.PENDING);
        List<PendingComplaints> pendingComplaints=new ArrayList<>();

        for(Complaint c : complaints)
        {
            PendingComplaints pc=new PendingComplaints(
                    c.getComplaintId(),c.getCitizen().getName(),c.getDescription(),c.getArea(),c.getCreatedDate(),c.getImageUrl());
            pendingComplaints.add(pc);


        }
        return pendingComplaints;
    }
    public void acceptComplaint(Long id, PrioritySet priority) {
        Complaint complaint = complaintRepository.findById(id).orElseThrow();
        complaint.setStatus(ComplaintStatus.ACCEPTED);
        complaint.setPrioritySet(priority);
        complaintRepository.save(complaint);
    }
    public void rejectComplaint(Long id) {
        Complaint complaint = complaintRepository.findById(id).orElseThrow();
        complaint.setStatus(ComplaintStatus.REJECTED);
        complaintRepository.save(complaint);
    }

    public List<AllComplaints> getAllComplaints()
    {
        List<Complaint> complaints=complaintRepository.findAll();
        List<AllComplaints> allComplaints=new ArrayList<>();
        for(Complaint c : complaints)
        {
            AllComplaints ac=new AllComplaints(
                    c.getComplaintId(),c.getCitizen().getName(),
                    c.getDescription(),c.getArea(),c.getCreatedDate(),c.getStatus(), c.getImageUrl(),c.getPrioritySet());
            allComplaints.add(ac);


        }
        return allComplaints;

    }

}
