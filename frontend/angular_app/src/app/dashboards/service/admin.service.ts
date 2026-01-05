import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl = 'http://localhost:8080/api/admin';

  constructor(private http: HttpClient) {}

  getPendingComplaints():Observable<any[]>{
    return this.http.get<any[]>(`${this.baseUrl}/pending`);
    }
  getAllComplaints():Observable<any[]>{
      return this.http.get<any[]>(`${this.baseUrl}/all`);
      }
   acceptComplaint(id: number,priority:string) {
      return this.http.post(`${this.baseUrl}/${id}/accept`, {priority});
    }

    rejectComplaint(id: number) {
      return this.http.post(`${this.baseUrl}/${id}/reject`, {});
    }
  }
