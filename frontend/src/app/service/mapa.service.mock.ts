import { of } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { Produtor } from '../model/produtor.model';

export class MapaServiceMock {

  findProdutores(lat: number, lng: number): Observable<Produtor[]> {
    return of([new Produtor]);
  }

}
