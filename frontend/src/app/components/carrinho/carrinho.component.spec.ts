import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PedidoService } from 'src/app/service/pedidos.service';
import { PedidoServiceMock } from 'src/app/service/pedidos.service.mock';

import { CarrinhoComponent } from './carrinho.component';

describe('CarrinhoComponent', () => {
  let component: CarrinhoComponent;
  let fixture: ComponentFixture<CarrinhoComponent>;

  const produto1 = {
    nomePedido: 'Produto 1',
    quantidadePedido: 1,
    precoPedido: 1,
  };

  const produto2 = {
    nomePedido: 'Produto 2',
    quantidadePedido: 2,
    precoPedido: 4,
  }

  const listaProdutos = [
    produto1,
    produto2
  ];

  const pedido = {
    idProdutor: '1',
    listaProdutos,
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarrinhoComponent ],
      providers: [
        { provide: PedidoService, useClass: PedidoServiceMock }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarrinhoComponent);
    component = fixture.componentInstance;
    
    window.localStorage.setItem('carrinhoPedido', JSON.stringify(pedido));

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should test pegaItensCarrinho method', () => {
    spyOn(component, 'pegaItensCarrinho').and.callThrough();
    component.pegaItensCarrinho();
    expect(component.pegaItensCarrinho).toHaveBeenCalled();
    expect(component.listaProdutos).toBeDefined();
  });

  it('should test calculaPrecoTotal method', () => {
    spyOn(component, 'calculaPrecoTotal').and.callThrough();
    component.calculaPrecoTotal(listaProdutos);
    expect(component.calculaPrecoTotal).toHaveBeenCalled();
    expect(component.totalFinal).toBeDefined();
    expect(component.totalFinal).toEqual(5);
  });

  it('should test fecharPedido method', () => {
    spyOn(component, 'fecharPedido').and.callThrough();
    component.fecharPedido();
    expect(component.fecharPedido).toHaveBeenCalled();
    expect(component.totalFinal).toEqual(0);
  });

  it('should test removerItem method', () => {
    spyOn(component, 'removerItem').and.callThrough();
    component.removerItem(produto1);
    expect(component.removerItem).toHaveBeenCalled();
  });
});
