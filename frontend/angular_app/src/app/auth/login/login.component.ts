import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { LoginService } from '../service/login.service';
import { jwtDecode } from 'jwt-decode';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email = '';
  password = '';
  errorMessage = '';

  constructor(
    private loginService: LoginService,
    private router: Router
  ) {}

  login() {
    localStorage.removeItem('token');
    this.errorMessage = '';

    if (!this.email || !this.password) {
      this.errorMessage = 'Email and password are required';
      return;
    }

    const body = {
      email: this.email,
      password: this.password
    };

    this.loginService.login(body).subscribe({
      next: (response: any) => {
        if (!response || !response.token) {
          this.errorMessage = 'Invalid login response';
          return;
        }

        localStorage.setItem('token', response.token);

        const decoded: any = jwtDecode(response.token);
        const role = decoded.role?.toUpperCase();

        if (role === 'CITIZEN') {
          this.router.navigate(['/citizen-dashboard']);
        } else if (role === 'OFFICER') {
          this.router.navigate(['/officer-dashboard']);
        } else if (role === 'ADMIN') {
          this.router.navigate(['/admin-dashboard']);
        } else {
          this.errorMessage = 'Unknown role';
        }
      },
      error: (err) => {
        this.errorMessage = err.error?.message || 'Login failed';
      }
    });
  }
}
