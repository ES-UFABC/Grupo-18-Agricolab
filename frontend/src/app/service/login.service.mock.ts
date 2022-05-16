import { of } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { Consumidor } from '../model/consumidor.model';
import { Produtor } from '../model/produtor.model';

export class LoginServiceMock {

  loginProdutor(params): Observable<Produtor> {
    return of(new Produtor);
  }
  
  loginConsumidor(params): Observable<Consumidor> {
    return of(new Consumidor);
  }

}
