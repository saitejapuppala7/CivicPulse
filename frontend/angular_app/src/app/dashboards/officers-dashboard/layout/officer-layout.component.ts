import {Component,ElementRef,HostListener,ViewChild} from '@angular/core';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-officer-dashboard',
  imports :[ RouterModule,CommonModule],
    standalone: true,
  templateUrl: './officer-layout.component.html',
  styleUrls: ['./officer-layout.component.css']
})
export class OfficerDashboardComponent {

  department = 'Public Works';
  departmentEmail = 'publicworks@city.gov';

  showProfile = false;

  @ViewChild('profileRef', { static: false })
  profileRef!: ElementRef;

  constructor(private router: Router) {}

  toggleProfile(event: MouseEvent) {
    event.stopPropagation();
    this.showProfile = !this.showProfile;
  }

  @HostListener('document:click', ['$event'])
  closeProfileOnOutsideClick(event: MouseEvent) {
    const target = event.target as HTMLElement;

    if (
      this.showProfile &&
      !target.closest('.profile')
    ) {
      this.showProfile = false;
    }
  }

  changePassword() {
    console.log('Change password clicked');
    }

  logout() {
    console.log('Officer logged out');

  }
}
