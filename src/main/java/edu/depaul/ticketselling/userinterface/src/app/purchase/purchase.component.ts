import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Event } from '../model/event.model';
import { EventsService } from '../services/events.services';

@Component({
  selector: 'app-purchase',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit {
  events: Event[] = []; // Add an events array
  event: Event | undefined;
  purchaseForm: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private eventsService: EventsService,
    private formBuilder: FormBuilder
  ) {
    this.purchaseForm = this.formBuilder.group({
      event: ['', Validators.required],
      quantity: [1, [Validators.required, Validators.min(1), Validators.max(10)]],
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const eventId = +params['id'];
      this.event = this.eventsService.getEventById(eventId);
      if (this.event) {
        // Automatically select the event in the form if navigating with an event ID
        this.purchaseForm.patchValue({
          event: this.event.id
        });
      } else {
        console.error('Event not found!');
      }
    });

    // Fetch all events to populate the events dropdown
    this.eventsService.getEvents().subscribe(events => {
      this.events = events;
    });
  }

  onSubmit() {
    if (this.purchaseForm.valid) {
      console.log('Form Submission:', this.purchaseForm.value);
    } else {
      console.error('Form is not valid');
    }
  }
}
