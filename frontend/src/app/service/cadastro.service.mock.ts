import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of, take } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { Consumidor } from '../model/consumidor.model';
import { Produtor } from '../model/produtor.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CadastroServiceMock {

  //Produtor
  getProdutores(): Observable<Produtor[]> {
    return of([new Produtor()]);
  }

  getProdutor(id: number): Observable<Produtor> {
    if(id) {
      const produtor = new Produtor();
      produtor.enderecoProdutor = 'Rua Teste;100;Bairro;Cidade;Estado';
      return of(produtor);
    }
    return of(new Produtor());
  }

  postProdutor(params): Observable<Produtor> {
    return of(new Produtor());
  }

  patchProdutor(params, id): Observable<Produtor> {
    return of(new Produtor());
  }

  deleteProdutor(id: number): Observable<Produtor> {
    return of(new Produtor());
  }

  //Consumidor
  getConsumidores(): Observable<Consumidor[]> {
    return of([new Consumidor()]);
  }

  getConsumidor(id: number): Observable<Consumidor> {
    return of(new Consumidor());
  }

  postConsumidor(params): Observable<Consumidor> {
    return of(new Consumidor());
  }

  patchConsumidor(params, id): Observable<Consumidor> {
    return of(new Consumidor());
  }

  deleteConsumidor(id: number): Observable<Consumidor> {
    return of(new Consumidor());
  }

  //Valida Email
  validaEmail(email: string): Observable<Boolean> {
    return of(true);
  }
}
