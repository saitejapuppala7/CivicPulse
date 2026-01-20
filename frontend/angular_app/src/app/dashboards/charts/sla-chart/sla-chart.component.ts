import { Component, AfterViewInit, OnDestroy, ViewChild, ElementRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AnalyticsService } from '../../service/analytics.service';
import Chart from 'chart.js/auto';

@Component({
  selector: 'app-sla-chart',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './sla-chart.component.html',
  styleUrls: ['./sla-chart.component.css']
})
export class SlaChartComponent implements AfterViewInit, OnDestroy {

  @ViewChild('slaCanvas') canvas!: ElementRef<HTMLCanvasElement>;

  chart?: Chart;

  constructor(private analyticsService: AnalyticsService) {}

  ngAfterViewInit(): void {
    this.loadSlaChart();
  }

  loadSlaChart() {
    this.analyticsService.getSlaReport().subscribe(data => {

      const met = data.slaMet;
      const missed = data.slaMissed;

      if (this.chart) {
        this.chart.destroy();
      }

      this.chart = new Chart(this.canvas.nativeElement, {
        type: 'doughnut',
        data: {
          labels: ['SLA Met', 'SLA Missed'],
          datasets: [{
            data: [met, missed],
            borderWidth: 1
          }]
        },
        options: {
          responsive: true,
          plugins: {
            legend: { position: 'bottom' },
            title: {
              display: true,
              text: 'SLA Performance'
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
