import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component'; // Updated import
import { PurchaseComponent } from './purchase/purchase.component';
import { GetStartedComponent } from './get-started/get-started.component';

export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    {
        path: 'dashboard',
        component: DashboardComponent,
        children: [
            { path: 'get-started', component: GetStartedComponent }, // Redirect to GetStartedComponent by default
            { path: 'home', component: HomeComponent },
            { path: 'purchase', component: PurchaseComponent },
        ]
    },
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: '**', redirectTo: '/login' }
];
@NgModule({
    imports: [RouterModule.forRoot(routes),],
    exports: [RouterModule]
})
export class AppRoutingModule { }