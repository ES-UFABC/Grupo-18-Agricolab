import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { PedidoService } from 'src/app/service/pedidos.service';
import { PedidoServiceMock } from 'src/app/service/pedidos.service.mock';

import { ApagarPedidosRecebidosComponent } from './apagar-pedidos-recebidos.component';

describe('ApagarPedidosRecebidosComponent', () => {
  let component: ApagarPedidosRecebidosComponent;
  let fixture: ComponentFixture<ApagarPedidosRecebidosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApagarPedidosRecebidosComponent ],
      providers: [
        { provide: PedidoService, useClass: PedidoServiceMock }
      ],
      imports: [ RouterModule.forRoot([]), ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApagarPedidosRecebidosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
