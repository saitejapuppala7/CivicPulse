import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-complaint-details',
     imports :[ RouterModule,CommonModule,FormsModule],
    templateUrl: './complaint-details.component.html',
  styleUrls: ['./complaint-details.component.css']
})
export class ComplaintInDetailComponent implements OnInit {

  c!: any;


  rating: number = 0;
  feedbackText: string = '';
  isFeedbackSubmitted = false;

  private baseUrl = 'http://localhost:8080/api/citizen';

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.loadComplaint(id);
    }
  }

  loadComplaint(id: string) {
    this.http.get(`${this.baseUrl}/complaint/${id}`).subscribe({
      next: (data) => {
        this.c = data;
        if (this.c.rating != null && this.c.feedback != null && this.c.feedback !== '') {
                this.isFeedbackSubmitted = true;
              } else {
                this.isFeedbackSubmitted = false;
                }
      },
      error: (err) => {
        console.error('Failed to load complaint', err);
      }
    });
  }

  submitFeedback() {
     if (this.isFeedbackSubmitted) {
        alert('Thank you, you already submitted feedback');
        return;
      }

    if (this.rating === 0 || !this.feedbackText.trim()) {
      alert('Please provide rating and feedback');
      return;
    }


    const payload = {
      rating: this.rating,
      feedback: this.feedbackText
    };
  console.log(payload);

    this.http.post(`${this.baseUrl}/complaint/${this.c.id}/feedback`, payload,{ responseType: 'text' })
      .subscribe({
        next: () => {
          alert('Feedback submitted successfully');
          this.isFeedbackSubmitted = true;

                  this.c.rating = this.rating;
                  this.c.feedback = this.feedbackText;
          this.feedbackText = '';
          this.rating = 0;
          console.log(payload);
        },
        error: (err) => {
          console.error('Failed to submit feedback', err);
          alert('Failed to submit feedback');
        }
      });
  }

  reopenComplaint() {

    if (!confirm('Are you sure you want to reopen this complaint?')) {
      return;
    }

    this.http.put(`${this.baseUrl}/${this.c.id}/reopen`, {})
      .subscribe({
        next: () => {
          alert('Complaint reopened');
          this.c.status = 'OPEN';
        },
        error: (err) => {
          console.error('Failed to reopen complaint', err);
          alert('Failed to reopen complaint');
        }
      });
  }
}
