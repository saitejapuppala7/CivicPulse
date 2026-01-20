import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AnalyticsService {

  private baseUrl = 'http://localhost:8080/api/analytics';

  constructor(private http: HttpClient) {}

  getCategoryWise(): Observable<Record<string, number>> {
    return this.http.get<Record<string, number>>(`${this.baseUrl}/category`);
  }

  getZoneWise(): Observable<Record<string, number>> {
    return this.http.get<Record<string, number>>(`${this.baseUrl}/zone`);
  }

  getSlaReport(): Observable<{ slaMet: number; slaMissed: number }> {
    return this.http.get<{ slaMet: number; slaMissed: number }>(`${this.baseUrl}/sla`);
  }

  getRedZones(): Observable<{ zone: string; count: number }[]> {
    return this.http.get<{ zone: string; count: number }[]>(`${this.baseUrl}/red-zones`);
  }
}

