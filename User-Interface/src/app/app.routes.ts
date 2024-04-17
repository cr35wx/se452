import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component'; // Updated import
import { PurchaseComponent } from './purchase/purchase.component';
import { GetStartedComponent } from './get-started/get-started.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';



export const routes: Routes = [
    // Set HomeComponent as the root
    { path: '', component: LoginComponent, pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'admin-login', component: AdminLoginComponent, 
    children: [
        { path: 'admin-dashboard', component: AdminDashboardComponent },
    ]},
    

    // Define Dashboard with child routes
    { path: 'dashboard', component: DashboardComponent, children: [
        { path: '', redirectTo: 'get-started', pathMatch: 'full' },  // Make GetStartedComponent the default under Dashboard
        { path: 'get-started', component: GetStartedComponent },
        { path: 'home', component: HomeComponent },
        { path: 'purchase', component: PurchaseComponent },
    ]},

    // Fallback for any non-defined routes to Home
    { path: '**', redirectTo: '/' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes),],
    exports: [RouterModule]
})
export class AppRoutingModule { }