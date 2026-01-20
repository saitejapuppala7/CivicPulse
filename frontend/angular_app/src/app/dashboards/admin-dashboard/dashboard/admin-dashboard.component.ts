import { Component, OnInit } from '@angular/core';
import { CategoryChartComponent } from '../../charts/category-chart/category-chart.component';
import { ZoneChartComponent } from '../../charts/zone-chart/zone-chart.component';
import { SlaChartComponent } from '../../charts/sla-chart/sla-chart.component';
import { HeatmapComponent } from '../../charts/heatmap/heatmap.component';


@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
   imports: [
      CategoryChartComponent,
      ZoneChartComponent,
      SlaChartComponent,
      HeatmapComponent
    ],
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  totalComplaints: number = 0;
  pendingComplaints: number = 0;
  acceptedComplaints: number = 0;
  rejectedComplaints: number = 0;

  constructor() {}

  ngOnInit(): void {
    this.loadDashboardData();
  }

  loadDashboardData(): void {
    this.totalComplaints = 120;
    this.pendingComplaints = 25;
    this.acceptedComplaints = 80;
    this.rejectedComplaints = 15;
  }
}
