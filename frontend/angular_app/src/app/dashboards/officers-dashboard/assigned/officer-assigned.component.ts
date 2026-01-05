import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { OfficerService } from '../../service/officer.service';

@Component({
  selector: 'app-assigned-details',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './officer-assigned.component.html',
  styleUrls: ['./officer-assigned.component.css']
})
export class OfficerAssignedComponent implements OnInit {

  allComplaints: any[] = [];

  constructor(
    private officerService: OfficerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadAssignedComplaints();
  }

  loadAssignedComplaints(): void {
    this.officerService.getAssignedComplaints().subscribe({
      next: (data) => {
        this.allComplaints = data;
      },
      error: () => {
        alert('Failed to load assigned complaints');
      }
    });
  }

viewComplaint(id: number): void {
  this.router.navigate(['/officers-dashboard/complaint', id]);
}

}

