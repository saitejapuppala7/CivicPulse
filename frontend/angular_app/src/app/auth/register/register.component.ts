import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RegisterService } from '../service/register.service';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, RouterModule,CommonModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  name = "";
  mobile = "";
  address = "";
  email = "";
  password = "";
  confirmPassword = "";
  errorMessage = "";

  constructor(private registerService: RegisterService, private router: Router) {}

  register() {
     if (!this.name || !this.email || !this.password || !this.confirmPassword) {
        return;
      }

    if (this.password !== this.confirmPassword) {
      this.errorMessage = "Passwords do not match!";
      return;
    }

    const body = {
      name: this.name,
      mobile: this.mobile,
      address: this.address,
      email: this.email,
      password: this.password,
      confirmPassword: this.confirmPassword
    };

    this.registerService.register(body).subscribe(
      (res:any) => {
        alert("Registration Successful!");
        this.router.navigate(['/login']);
      },
      (err:any) => {
        this.errorMessage = "Registration failed!";
      }
    );
  }
}
