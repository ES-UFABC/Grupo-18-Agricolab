import { of } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { Produto } from '../model/produto.model';

export class ProdutoServiceMock {

  postProduto(params, id): Observable<Produto> {
    return of(new Produto);
  }

  deleteProduto(id): Observable<Produto> {
    return of(new Produto);
  }

  putProduto(params, id): Observable<Produto> {
    return of(new Produto);
  }

}
