import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OfficerService } from '../../service/officer.service';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-complaint-resolved',
   imports :[ RouterModule,CommonModule,FormsModule],
  templateUrl: './officer-resolved.component.html',
  styleUrls: ['./officer-resolved.component.css']
})
export class OfficerResolvedComponent implements OnInit {

  complaints:any[] = [];
  constructor(
    private route: ActivatedRoute,
    private officerService: OfficerService
  ) {}

  ngOnInit(): void {
    this.officerService.getResolvedComplaints().subscribe({
          next: data => this.complaints = data,
          error: () => alert('Failed to load complaint')
        });
      }

    }


