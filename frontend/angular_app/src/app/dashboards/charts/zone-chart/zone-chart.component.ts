import { Component, AfterViewInit, OnDestroy, ViewChild, ElementRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AnalyticsService } from '../../service/analytics.service';
import Chart from 'chart.js/auto';

@Component({
  selector: 'app-zone-chart',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './zone-chart.component.html',
  styleUrls: ['./zone-chart.component.css']
})
export class ZoneChartComponent implements AfterViewInit, OnDestroy {

  @ViewChild('zoneCanvas', { static: true })
  canvas!: ElementRef<HTMLCanvasElement>;


  chart?: Chart;

  constructor(private analyticsService: AnalyticsService) {}

  ngAfterViewInit(): void {
    this.loadZoneChart();
  }

  loadZoneChart() {
    this.analyticsService.getZoneWise().subscribe(data => {

      const labels = Object.keys(data);
      const values = Object.values(data);

      if (this.chart) {
        this.chart.destroy();
      }

      this.chart = new Chart(this.canvas.nativeElement, {
        type: 'bar',
        data: {
          labels,
          datasets: [{
            label: 'Complaints',
            data: values,
            borderWidth: 1
          }]
        },
        options: {
          responsive: true,
          plugins: {
            legend: { display: false },
            title: {
              display: true,
              text: 'Complaints by Zone'
            }
          },
          scales: {
            y: { beginAtZero: true }
          }
        }
      });

    });
  }

  ngOnDestroy(): void {
    if (this.chart) {
      this.chart.destroy();
    }
  }
}
