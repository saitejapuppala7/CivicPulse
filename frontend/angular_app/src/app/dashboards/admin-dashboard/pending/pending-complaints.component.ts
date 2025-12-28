import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminService } from '../../service/admin.service';

@Component({
  selector: 'app-pending-complaints',
  standalone: true,
  imports: [CommonModule],
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

  acceptComplaint(id: number) {
    this.adminService.acceptComplaint(id).subscribe(() => {
      this.pendingComplaints = this.pendingComplaints.filter(
        c => c.id !== id
      );
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

