import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OfficerService {

  private baseUrl = 'http://localhost:8080/api/officer';

  constructor(private http: HttpClient) {}

  getAssignedComplaints(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/complaints`);
  }

  getComplaintById(id: string): Observable<any> {
    return this.http.get<any>(
      `${this.baseUrl}/complaint/${id}`
    );
  }

  resolveComplaint(id: number, data: FormData): Observable<any> {
    return this.http.post(
      `${this.baseUrl}/complaint/${id}/resolve`,data
    );
  }

  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    return new HttpHeaders({
      Authorization: `Bearer ${token}`
    });
  }

  private getMultipartAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    return new HttpHeaders({
      Authorization: `Bearer ${token}`
    });

  }

getResolvedComplaints(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/complaint/resolved`);
  }
}
