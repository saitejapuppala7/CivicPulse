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

  const formData = new FormData();

  formData.append('category', this.complaint.category);
  formData.append('description', this.complaint.description);
  formData.append('area', this.complaint.area);
  formData.append('city', this.complaint.city);
  formData.append('landmark', this.complaint.landmark);
  formData.append('declaration', String(this.complaint.declaration));

  if (this.complaint.latitude !== null)
    formData.append('latitude', this.complaint.latitude.toString());

  if (this.complaint.longitude !== null)
    formData.append('longitude', this.complaint.longitude.toString());


  if (this.complaint.image) {
    formData.append('image', this.complaint.image);
  }

  this.homeService.submitForm(formData).subscribe({
    next: () => {
      alert('Thank You! Your Complaint Registered Successfully');

    },
    error: err => console.error(err)
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



