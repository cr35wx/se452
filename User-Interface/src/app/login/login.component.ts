import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import { MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import {MatButton} from '@angular/material/button';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, 
    MatInputModule, 
    MatFormFieldModule,
    MatInputModule,
    MatLabel,
    MatCardModule,
    MatButton,
    RouterOutlet,
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  constructor(private router: Router) {}

  username: string = '';
  password: string = '';

  login() {
    console.log('Login clicked:', this.username, this.password);

    this.router.navigate(['/dashboard']);
  }
}
