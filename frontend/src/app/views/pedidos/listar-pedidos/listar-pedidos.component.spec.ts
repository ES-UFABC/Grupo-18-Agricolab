import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CadastroService } from 'src/app/service/cadastro.service';
import { CadastroServiceMock } from 'src/app/service/cadastro.service.mock';

import { ListarPedidosComponent } from './listar-pedidos.component';

describe('ListarPedidosComponent', () => {
  let component: ListarPedidosComponent;
  let fixture: ComponentFixture<ListarPedidosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarPedidosComponent ],
      providers: [
        { provide: CadastroService, useClass: CadastroServiceMock },
      ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarPedidosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
