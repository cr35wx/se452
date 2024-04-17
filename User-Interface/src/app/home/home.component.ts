import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatButton } from '@angular/material/button';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatCardModule, MatIconModule, MatButton],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  items = [
    { title: 'Card 1', description: 'Description for card 1' },
    { title: 'Card 2', description: 'Description for card 2' },
    { title: 'Card 3', description: 'Description for card 3' },

  ];
  currentIndex = 0; 

  incrementIndex() {
    this.currentIndex = (this.currentIndex + 1) % this.items.length;
  }

  decrementIndex() {
    this.currentIndex = (this.currentIndex - 1 + this.items.length) % this.items.length;
  }
}

