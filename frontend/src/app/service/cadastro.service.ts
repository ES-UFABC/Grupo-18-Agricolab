import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { Produtor } from '../model/produtor';
import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {

  private readonly API = `${environment.API}`;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
  ) { }

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

}
