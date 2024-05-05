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
  events: Event[] = [];
  event: Event | undefined;
  purchaseForm: FormGroup;
  totalCost: number = 0;

  constructor(
    private route: ActivatedRoute,
    private eventsService: EventsService,
    private formBuilder: FormBuilder
  ) {
    // Initialize the form here to be updated later in ngOnInit
    this.purchaseForm = this.formBuilder.group({
      event: ['', Validators.required],
      quantity: [1, [Validators.required, Validators.min(1), Validators.max(10)]],
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  ngOnInit() {
    this.eventsService.getEvents().subscribe(events => {
      this.events = events;
    });

    this.route.params.subscribe(params => {
      const eventId = +params['id'];
      this.event = this.eventsService.getEventById(eventId);
      if (this.event) {
        this.purchaseForm.patchValue({
          event: this.event.id,
          quantity: 1 // Set a default value for quantity
        });
        this.updateTotalCost(); // Update total cost based on the selected event
      } else {
        console.error('Event not found!');
      }
    });

    this.initializeListeners();
  }

  initializeListeners() {
    this.purchaseForm.get('event')?.valueChanges.subscribe(eventId => {
      this.updateEventDetails(eventId);
    });

    this.purchaseForm.get('quantity')?.valueChanges.subscribe(() => {
      setTimeout(() => {
      this.updateTotalCost();
      },0);
    });
  }

  updateEventDetails(eventId: number) {
    this.event = this.eventsService.getEventById(eventId);
    if (this.event) {
        // Ensure we immediately reflect price changes when the event changes
        this.updateTotalCost();
    } else {
        console.error('Event not found!');
        this.totalCost = 0; // Reset total cost if no event is found
    }
}

updateTotalCost() {
  // Debug logging to help trace the calculations
  console.log('Calculating total cost for event:', this.event);
  console.log('Current quantity:', this.purchaseForm.value.quantity);
  if (this.event && this.purchaseForm.value.quantity) {
      this.totalCost = this.event.defaultPrice * this.purchaseForm.value.quantity;
  } else {
      this.totalCost = 0; // Ensure we reset to 0 if there's no valid event or quantity is undefined
  }
  console.log('New total cost:', this.totalCost);
}

  onSubmit() {
    if (this.purchaseForm.valid) {
      console.log('Form Submission:', this.purchaseForm.value);
      console.log('Total Cost:', this.totalCost);
    } else {
      console.error('Form is not valid');
    }
  }
}