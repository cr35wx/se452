import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Account } from '../model/account.model'; // Adjust the import path as necessary
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class AccountService {
    constructor(private http: HttpClient) {
     }

    login(username: string, password: string): Observable<boolean> {
        const users = this.http.get<Account[]>('https://66614d1063e6a0189fe92ce5.mockapi.io/api/v1/accounts').subscribe(users => {
            if(users[0].username === username && users[0].password === password) {
                return of(true);
            } else {
                return of(false);
            }
        });
        return of(false);
    }

}
