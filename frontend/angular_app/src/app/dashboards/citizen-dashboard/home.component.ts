import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeService } from '../service/home.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  imports: [CommonModule],
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  user: any = {};
  complaints:any[]=[];

  currentView: string = 'home';

  constructor(
    private homeService: HomeService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadUserProfile();
  }

  loadUserProfile() {
    this.homeService.getUserProfile().subscribe(
      (data: any) => {
        this.user = data;
      },
      (error: any) => {
        console.error('Error loading user profile', error);
      }
    );
  }

  goToComplaint() {
    this.router.navigate(['./report-complaint']);
  }

  setView(view: string) {
    this.currentView = view;
    if (view === 'track') {
        this.loadComplaints();
      }
  }
 loadComplaints(){
   this.homeService.getComplaints().subscribe(
     (data:any)=>{
       this.complaints=data;
       },
     (error:any)=>{
       console.error("loading user complaints ",error);
       }
     );
   }
 viewComplaint(id: number): void {
   this.router.navigate(['/citizen-dashboard/complaint-in-detail', id]);
   }

}
