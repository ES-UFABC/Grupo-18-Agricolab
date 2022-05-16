import { of } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { Consumidor } from '../model/consumidor.model';
import { Produto } from '../model/produto.model';

export class PedidoServiceMock {

  postPedido(params, idProdutor, idConsumidor): Observable<Consumidor> {
    return of(new Consumidor);
  }

  deletePedido(idPedido): Observable<void> {
    return of(undefined);
  }

  putPedido(params, idPedido): Observable<Produto> {
    return of(new Produto);
  }

}
