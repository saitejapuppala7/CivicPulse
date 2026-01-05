import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminService } from '../../service/admin.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-pending-complaints',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './pending-complaints.component.html',
  styleUrls: ['./pending-complaints.component.css']
})
export class PendingComplaintsComponent implements OnInit {

  pendingComplaints: any[] = [];

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.loadPendingComplaints();
  }

  loadPendingComplaints() {
    this.adminService.getPendingComplaints().subscribe(
      (data: any) => {
        this.pendingComplaints = data;
      },
      (error:any) => console.error(error)
    );
  }

   acceptComplaint(complaint: any): void {
     if (!complaint.priority) {
       alert('Please select priority');
       return;
     }

     this.adminService
       .acceptComplaint(complaint.id, complaint.priority)
       .subscribe({
         next: () => {
           alert('Complaint accepted');
           this.loadPendingComplaints();
         },
         error: () => alert('Accept failed')
       });
   }

  rejectComplaint(id: number) {
    this.adminService.rejectComplaint(id).subscribe(() => {
      this.pendingComplaints = this.pendingComplaints.filter(
        c => c.id !== id
      );
    });
  }
}

