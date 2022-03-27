import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { Produtor } from '../model/produtor.model';
import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {

  private readonly API = `${environment.API}`;

  constructor(
    private http: HttpClient,
  ) { }

  //Produtor
  getProdutores(): Observable<Produtor[]> {
    return this.http.get<Produtor[]>(`${this.API}/produtor`).pipe(take(1));
  }

  getProdutor(id: number): Observable<Produtor> {
    return this.http.get<Produtor>(`${this.API}/produtor/${id}`).pipe(take(1));
  }

  postProdutor(params): Observable<Produtor> {
    return this.http.post<Produtor>(`${this.API}/produtor`, params).pipe(take(1));
  }

  putProdutor(params): Observable<Produtor> {
    return this.http.put<Produtor>(`${this.API}/produtor`, params).pipe(take(1));
  }

  deleteProdutor(id: number): Observable<Produtor> {
    return this.http.delete<Produtor>(`${this.API}/produtor/${id}`).pipe(take(1));
  }

  //Consumidor
  getConsumidores(): Observable<Produtor[]> {
    return this.http.get<Produtor[]>(`${this.API}/consumidor`).pipe(take(1));
  }

  getConsumidor(id: number): Observable<Produtor> {
    return this.http.get<Produtor>(`${this.API}/consumidor/${id}`).pipe(take(1));
  }

  postConsumidor(params): Observable<Produtor> {
    return this.http.post<Produtor>(`${this.API}/consumidor`, params).pipe(take(1));
  }

  putConsumidor(params): Observable<Produtor> {
    return this.http.put<Produtor>(`${this.API}/consumidor`, params).pipe(take(1));
  }

  deleteConsumidor(id: number): Observable<Produtor> {
    return this.http.delete<Produtor>(`${this.API}/consumidor/${id}`).pipe(take(1));
  }

}
