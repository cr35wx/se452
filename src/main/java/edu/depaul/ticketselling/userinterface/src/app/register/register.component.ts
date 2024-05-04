import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  email: string = '';
  username: string = '';
  password: string = '';
  phoneNumber: string = '';
  
  
  constructor(private router: Router){}

  register() {
    console.log('Register clicked:', this.email, this.username, this.password, this.phoneNumber);
    // Navigate to dashboard
    this.router.navigate(['/dashboard']);
  }
  login(){
    this.router.navigate(['/login']);
  }
}
