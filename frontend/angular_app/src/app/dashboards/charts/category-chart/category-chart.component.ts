import { Component, AfterViewInit, OnDestroy } from '@angular/core';
import { AnalyticsService } from '../../service/analytics.service';
import Chart from 'chart.js/auto';
import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-category-chart',
   imports: [CommonModule,FormsModule],
  templateUrl: './category-chart.component.html',
  styleUrls: ['./category-chart.component.css']
})
export class CategoryChartComponent implements AfterViewInit, OnDestroy {

  chart: Chart | undefined;

  constructor(private analyticsService: AnalyticsService) {}

  ngAfterViewInit(): void {
    this.loadChart();
  }

  loadChart() {
    this.analyticsService.getCategoryWise().subscribe(data => {

      const labels = Object.keys(data);
      const values = Object.values(data);

      const canvas = document.getElementById('categoryChart') as HTMLCanvasElement;

      if (this.chart) {
        this.chart.destroy();
      }

      this.chart = new Chart(canvas, {
        type: 'pie',
        data: {
          labels: labels,
          datasets: [{
            label: 'Complaints',
            data: values,
            borderWidth: 1
          }]
        },
        options: {
          responsive: true,
          plugins: {
            legend: {
              position: 'bottom'
            },
            title: {
              display: true,
              text: 'Complaints by Category'
            }
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
