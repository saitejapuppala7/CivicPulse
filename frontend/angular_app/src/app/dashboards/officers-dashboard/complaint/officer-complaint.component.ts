import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OfficerService } from '../../service/officer.service';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-complaint-details',
   imports :[ RouterModule,CommonModule,FormsModule],
  templateUrl: './officer-complaint.component.html',
  styleUrls: ['./officer-complaint.component.css']
})
export class ComplaintDetailsComponent implements OnInit {

  complaint: any = {};
  resolvedDescription = '';
  resolvedImage: File | null = null;

  constructor(
    private route: ActivatedRoute,
    private officerService: OfficerService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (!id) {
      alert('Invalid complaint ID');
      return;
    }

    this.officerService.getComplaintById(id).subscribe({
      next: data => this.complaint = data,
      error: () => alert('Failed to load complaint')
    });
  }

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.resolvedImage = input.files[0];
    }
  }

  markResolved(): void {
    if (this.complaint.status === 'RESOLVED') {
      alert('Complaint already resolved');
      return;
    }

    const formData = new FormData();
    formData.append('resolvedDescription', this.resolvedDescription);
    if (this.resolvedImage) {
      formData.append('resolvedImage', this.resolvedImage);
    }

    this.officerService
      .resolveComplaint(this.complaint.id, formData)
      .subscribe({
        next: () => alert('Complaint resolved successfully'),
        error: () => alert('Failed to resolve complaint')
      });
  }
}
