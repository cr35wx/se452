// src/app/services/events.service.ts
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Event } from '../model/event.model'; // Adjust the import path as necessary

@Injectable({
    providedIn: 'root'
})
export class EventsService {
    private events: Event[] = [
        {
            id: 1,
            title: 'Summer Music Festival',
            artist: 'The Cool Cats',
            venue: 'Downtown Arena',
            dateTime: new Date(2024, 5, 15, 20, 0), // June 15, 2024, 20:00
            color: 'from-blue-500',
            defaultPrice: 50
        },
        {
            id: 2,
            title: 'Jazz Nights',
            artist: 'Smooth Jazz Ensemble',
            venue: 'Riverside Jazz Club',
            dateTime: new Date(2024, 5, 20, 19, 30), // June 20, 2024, 19:30
            color: 'from-green-500',
            defaultPrice: 40
        },
        {
            id: 3,
            title: 'Rock & Roll Extravaganza',
            artist: 'The Rock Legends',
            venue: 'The Big Stadium',
            dateTime: new Date(2024, 6, 1, 18, 0), // July 1, 2024, 18:00
            color: 'from-red-500',
            defaultPrice: 60
        },
        {
            id: 4,
            title: 'Classical Evening',
            artist: 'City Orchestra',
            venue: 'Grand Concert Hall',
            dateTime: new Date(2024, 6, 11, 20, 0), // July 11, 2024, 20:00
            color: 'from-purple-500',
            defaultPrice: 55
        },
        {
            id: 5,
            title: 'Opera Night',
            artist: 'Metropolitan Opera Stars',
            venue: 'Opera House',
            dateTime: new Date(2024, 6, 18, 20, 0), // July 18, 2024, 20:00
            color: 'from-yellow-500',
            defaultPrice: 65
        },
        {
            id: 6,
            title: 'Indie Music Awards',
            artist: 'Various Artists',
            venue: 'City Theater',
            dateTime: new Date(2024, 6, 25, 19, 0), // July 25, 2024, 19:00
            color: 'from-indigo-500',
            defaultPrice: 45
        }
    ];

    constructor() { }

    getEvents(): Observable<Event[]> {
        return of(this.events);
    }

    getEventById(id: number): Event | undefined {
        console.log('Looking for event with ID:', id);
        const foundEvent = this.events.find(event => event.id === id);
        console.log('Found event:', foundEvent);
        return foundEvent;
    }

}
