import { Component, OnInit } from '@angular/core';
import { AnalyticsService } from '../../service/analytics.service';
import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-heatmap',
   imports: [CommonModule,FormsModule],
  templateUrl: './heatmap.component.html',
  styleUrls: ['./heatmap.component.css']
})
export class HeatmapComponent implements OnInit {

  zones: { zone: string; count: number }[] = [];

  constructor(private analyticsService: AnalyticsService) {}

  ngOnInit(): void {
    this.loadHeatZones();
  }

  loadHeatZones() {
    this.analyticsService.getRedZones().subscribe({
      next: (data) => {
        this.zones = data;
      },
      error: (err) => {
        console.error('Failed to load heat zones', err);
      }
    });
  }
}
