import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { environment } from '../../environments/environment';
import { Consumidor } from '../model/consumidor.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly API = `${environment.API}`;

  constructor(
    private http: HttpClient,
  ) { }

  //Produtor

  //Consumidor
  loginConsumidor(params): Observable<Consumidor> {
    return this.http.post<Consumidor>(`${this.API}/api/agricolab/v1/login`, params).pipe(take(1));
  }


}
