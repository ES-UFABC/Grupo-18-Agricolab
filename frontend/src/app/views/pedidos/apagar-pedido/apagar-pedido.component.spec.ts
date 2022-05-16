import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { PedidoService } from 'src/app/service/pedidos.service';
import { PedidoServiceMock } from 'src/app/service/pedidos.service.mock';

import { ApagarPedidoComponent } from './apagar-pedido.component';

describe('ApagarPedidoComponent', () => {
  let component: ApagarPedidoComponent;
  let fixture: ComponentFixture<ApagarPedidoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApagarPedidoComponent ],
      providers: [
        { provide: PedidoService, useClass: PedidoServiceMock }
      ],
      imports: [ RouterModule.forRoot([]), ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApagarPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should test apagar method', () => {
    spyOn(component, 'apagar').and.callThrough();
    component.apagar();
    expect(component.apagar).toHaveBeenCalled();
  });

});
