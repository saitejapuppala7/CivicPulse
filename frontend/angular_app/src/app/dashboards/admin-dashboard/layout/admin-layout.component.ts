import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-admin-layout',
  imports :[ RouterModule ],
  standalone: true,
  templateUrl: './admin-layout.component.html',
  styleUrls: ['./admin-layout.component.css']
})
export class AdminLayoutComponent {
  adminName = 'Sai Teja';
  adminEmail = 'admin@civicpulse.com';
  constructor(private router: Router) {}
  changePassword() {
    this.router.navigate(['/admin/change-password']);
  }
  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }
}

