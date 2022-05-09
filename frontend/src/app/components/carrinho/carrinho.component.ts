import { Component, OnInit } from '@angular/core';
import {
  trigger,
  state,
  style,
  animate,
  transition,
} from '@angular/animations';
import { setUsuario, UserSession } from 'src/app/views/login/login.component';
import { Pedido } from 'src/app/model/pedido.model';
import { ProdutoPedido } from 'src/app/model/produto-pedido.model';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.scss'],
  animations: [
    trigger('myInsertRemoveTrigger', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('500ms', style({ opacity: 1 })),
      ]),
      transition(':leave', [
        animate('500ms', style({ opacity: 0 }))
      ])
    ]),
  ]
})
export class CarrinhoComponent implements OnInit {
  showMenu = false;
  user: UserSession = setUsuario();
  listaProdutos: ProdutoPedido[];
  isPedidoFeito: boolean = false;
  totalFinal: number = 0;

  constructor() { }

  ngOnInit(): void {
    this.pegaItensCarrinho();
  }

  pegaItensCarrinho() {
    const pedido: any = window.localStorage.getItem('carrinhoPedido');
    const pedidoObject: Pedido = pedido ? JSON.parse(pedido) : '';

    if(pedidoObject) {
      this.listaProdutos = pedidoObject.listaProdutos;
      this.calculaPrecoTotal(this.listaProdutos);
      this.isPedidoFeito = false;
    }
  }

  calculaPrecoTotal(listaProdutos: ProdutoPedido[]) {
    this.totalFinal = listaProdutos.map(item => item.precoPedido).reduce((acc, value) => acc + value);
  }

  fecharPedido() {
    const pedido: any = window.localStorage.getItem('carrinhoPedido');
    const pedidoObject: Pedido = pedido ? JSON.parse(pedido) : '';

    if(pedidoObject) {

      window.localStorage.removeItem('carrinhoPedido');
      this.isPedidoFeito = true;
      this.totalFinal = 0;
      setTimeout(() => {
        window.location.reload();
      }, 1000);
    }
  }

}
