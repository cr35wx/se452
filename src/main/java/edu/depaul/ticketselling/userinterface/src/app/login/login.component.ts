import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private router: Router) {}

  login() {
    if(!this.username.trim() || !this.password) {
      console.log('Invalid username or password');
      alert('Please enter a valid username and password');
      return;
    }
    console.log('Login clicked:', this.username, this.password);
    this.router.navigate(['/nav', {username: this.username}]);
  }
  register() {
    this.router.navigate(['/register']);
  }
}
