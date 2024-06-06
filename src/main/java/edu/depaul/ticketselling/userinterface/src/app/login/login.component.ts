import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AccountService } from '../services/accounts.services';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  @Input() username: string = '';
  @Input() password: string = '';

  constructor(private accountsService: AccountService, private router: Router) {}

  login() {
    if(!this.username.trim() || !this.password) {
      console.log('Invalid username or password');
      alert('Please enter a valid username and password');
      
      this.accountsService.login(this.username, this.password).subscribe( (res: boolean) => {
        console.log('Login response:', res);
        if (res) {
          console.log('Login clicked:', this.username, this.password);
          this.router.navigate(['/nav', {username: this.username}]);
        } else {  
          console.log('Invalid username or password');
          alert('Please enter a valid username and password');
        }
      });
    }
    // console.log('Login clicked:', this.username, this.password);
    // this.router.navigate(['/nav', {username: this.username}]);
  }
  register() {
    this.router.navigate(['/register']);
  }
}
