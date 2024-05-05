import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PurchaseComponent } from './purchase/purchase.component';
import { GetStartedComponent } from './get-started/get-started.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { RegisterComponent } from './register/register.component';
import { NavComponent } from './nav/nav.component';
import { EventsComponent } from './events/events.component';
import { DashboardComponent } from './dashboard/dashboard.component';


export const routes: Routes = [
    // Set HomeComponent as the root
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent},
    { path: 'admin-login', component: AdminLoginComponent, 
    children: [
        { path: 'admin-dashboard', component: AdminDashboardComponent },
    ]},
    

    // Define Dashboard with child routes
    { path: 'nav', component: NavComponent, children: [
        { path: '', redirectTo: 'get-started', pathMatch: 'full' },  // Make GetStartedComponent the default under Dashboard
        { path: 'get-started', component: GetStartedComponent },
        { path: 'events', component: EventsComponent },
        { path: 'purchase', component: PurchaseComponent},
        { path: 'purchase/:id', component: PurchaseComponent },
        { path: 'dashboard', component: DashboardComponent},
    ]},

    // Fallback for any non-defined routes to Home
    { path: '**', redirectTo: '/' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }