import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { Event } from '../model/event.model';
import { EventsService } from '../services/events.services';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-events',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: 'events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {
  events: Event[] = [];  // Initialize events as an empty array.

  constructor(private eventsService: EventsService, private router: Router) {}

  ngOnInit() {
    this.eventsService.getEvents().subscribe(events => {
      this.events = events;
    });
  }

  buyTicket(eventId: number) {
    this.router.navigate(['/nav/purchase', eventId]);
  }

  getBackgroundClass(event: Event): string {
    return `bg-gradient-to-b ${event.color} to-white`;
  }
}
