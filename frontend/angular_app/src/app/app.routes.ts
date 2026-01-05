import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import {HomeComponent } from './dashboards/citizen-dashboard/home.component';
import { RegisterComplaint } from './dashboards/citizen-dashboard/report-complaint/complaint-handler.component';
import { AuthGuard } from './auth/guard/auth.guard';
import {AdminLayoutComponent} from './dashboards/admin-dashboard/layout/admin-layout.component';
import { AdminDashboardComponent } from './dashboards/admin-dashboard/dashboard/admin-dashboard.component';
import { PendingComplaintsComponent } from './dashboards/admin-dashboard/pending/pending-complaints.component';
import { AllComplaintsComponent } from './dashboards/admin-dashboard/all/all-complaints.component';
import {OfficerDashboardComponent} from './dashboards/officers-dashboard/layout/officer-layout.component';
import{  DashboardOverviewComponent} from './dashboards/officers-dashboard/dashboard/officer-dashboard.component';
import { ComplaintDetailsComponent} from './dashboards/officers-dashboard/complaint/officer-complaint.component';
import {OfficerAssignedComponent} from './dashboards/officers-dashboard/assigned/officer-assigned.component';
export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {path:'citizen-dashboard',component:HomeComponent,canActivate: [AuthGuard] },

  { path : 'report-complaint' , component : RegisterComplaint,canActivate: [AuthGuard] },
 { path: 'admin-dashboard',component: AdminLayoutComponent,children: [
                                                         { path: 'dashboard', component: AdminDashboardComponent},
                                                           {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
                                                           { path: 'pending', component: PendingComplaintsComponent},
                                                           { path: 'all', component: AllComplaintsComponent}
     ]
   },
 {path : 'officers-dashboard' , component: OfficerDashboardComponent, children:[
   { path: 'dashboard', component:  DashboardOverviewComponent},
   {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
   {path: 'assigned', component:OfficerAssignedComponent },
   {path: 'complaint/:id' ,component:ComplaintDetailsComponent}
   ]}
];



