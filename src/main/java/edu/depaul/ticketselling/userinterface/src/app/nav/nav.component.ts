import { Component } from '@angular/core';
import { MatSidenavModule, MatDrawer, MatDrawerContainer, MatDrawerContent } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { RouterModule } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButton } from '@angular/material/button';
import { Router } from '@angular/router';
import { GetStartedComponent } from '../get-started/get-started.component';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [MatSidenavModule,
    MatListModule,
    RouterModule,
    MatDrawer,
    MatDrawerContainer,
    MatDrawerContent,
    MatToolbarModule,
    MatIconModule,
    MatButton,
    GetStartedComponent 
  ],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {

  constructor(private router: Router) {}

  showFiller = false;
  redirectToEvents() {
    this.router.navigate(['/nav/events']);
  }
}
