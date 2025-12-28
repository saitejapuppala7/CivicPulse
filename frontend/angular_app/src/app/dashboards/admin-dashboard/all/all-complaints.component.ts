import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminService } from '../../service/admin.service';

@Component({
  selector: 'app-all-complaints',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './all-complaints.component.html',
  styleUrls: ['./all-complaints.component.css']
})
export class AllComplaintsComponent implements OnInit {

 allComplaints: any[] = [];

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.loadAllComplaints();
  }

  loadAllComplaints() {
    this.adminService.getAllComplaints().subscribe(
      (data: any) => {
        this.allComplaints = data;
      },
      (error:any) => console.error(error)
    );
  }


}

