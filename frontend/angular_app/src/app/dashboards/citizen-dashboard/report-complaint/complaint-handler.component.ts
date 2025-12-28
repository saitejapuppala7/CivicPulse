import { Component } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { HomeService } from '../../service/home.service';


@Component(
  {
    selector:'app-complaint',
    imports: [FormsModule, RouterModule],
    templateUrl:'./report-complaint.component.html',
    styleUrls:['./style-complaint.component.css']
    }
  )

export class RegisterComplaint {
  complaint={
    category: '',
        description: '',
        image: null as File | null,
        area: '',
        city: '',
        landmark: '',
        latitude: null as number | null,
        longitude: null as number | null,
        declaration: false
    };
  constructor (private homeService:HomeService ,private router:Router){}
onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.complaint.image = file;
      console.log('Image selected:', file.name);
    }

  }
   useCurrentLocation() {
      if (!navigator.geolocation) {
        alert('Geolocation not supported');
        return;
      }

navigator.geolocation.getCurrentPosition(
      (position:any) => {
        this.complaint.latitude = position.coords.latitude;
        this.complaint.longitude = position.coords.longitude;

        console.log('Location:', this.complaint.latitude, this.complaint.longitude);
        alert('Location captured successfully');
      },
      (error:any) => {
        alert('Unable to fetch location');
        console.error(error);
      }
    );
  }
submitComplaint() {

    if (
      !this.complaint.category ||
      !this.complaint.description ||
      (!this.complaint.latitude && !this.complaint.area) ||
      !this.complaint.declaration
    ) {
      alert('Please fill all mandatory fields');
      return;
    }
   this.homeService.submitForm(this.complaint).subscribe({
     next:(response:any)=>{
       alert('Thank You! Your Complaint Register Successfully');

       }
     });

     this.resetForm();
      }
resetForm() {
    this.complaint = {
      category: '',

      description: '',
      image: null,
      area: '',
      city: '',
      landmark: '',
      latitude: null,
      longitude: null,
      declaration: false
    };
  }
}



