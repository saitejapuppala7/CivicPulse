import { Component, OnInit } from '@angular/core';
import { ZoneChartComponent } from '../../charts/zone-chart/zone-chart.component';
import { SlaChartComponent } from '../../charts/sla-chart/sla-chart.component';
import { HeatmapComponent } from '../../charts/heatmap/heatmap.component';


@Component({
  selector: 'app-dashboard-overview',
  imports: [
        ZoneChartComponent,
        SlaChartComponent,
        HeatmapComponent
      ],
  templateUrl: './officer-dashboard.component.html',
  styleUrls: ['./officer-dashboard.component.css']
})
export class DashboardOverviewComponent implements OnInit {

  totalComplaints = 0;
  pendingComplaints = 0;
  resolvedComplaints = 0;
  highPriorityComplaints = 0;

  ngOnInit(): void {
    this.loadDashboardStats();
  }

  loadDashboardStats() {
    // Dummy data (replace with API call)
    this.totalComplaints = 1;
    this.pendingComplaints = 1;
    this.resolvedComplaints = 0;
    this.highPriorityComplaints = 0;
  }
}
