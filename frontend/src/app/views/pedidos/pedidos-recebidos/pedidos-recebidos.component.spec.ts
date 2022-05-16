import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CadastroService } from 'src/app/service/cadastro.service';
import { CadastroServiceMock } from 'src/app/service/cadastro.service.mock';

import { PedidosRecebidosComponent } from './pedidos-recebidos.component';

describe('PedidosRecebidosComponent', () => {
  let component: PedidosRecebidosComponent;
  let fixture: ComponentFixture<PedidosRecebidosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PedidosRecebidosComponent ],
      providers: [
        { provide: CadastroService, useClass: CadastroServiceMock },
      ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PedidosRecebidosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
