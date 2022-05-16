import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { CadastroService } from 'src/app/service/cadastro.service';
import { CadastroServiceMock } from 'src/app/service/cadastro.service.mock';

import { PedidosComponent } from './pedidos.component';

describe('PedidosComponent', () => {
  let component: PedidosComponent;
  let fixture: ComponentFixture<PedidosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PedidosComponent ],
      providers: [
        { provide: CadastroService, useClass: CadastroServiceMock },
      ],
      imports: [ RouterModule.forRoot([]), ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PedidosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should test getProdutor method', () => {
    const id = '1';

    spyOn(component, 'getProdutor').and.callThrough();
    component.getProdutor(id);
    expect(component.getProdutor).toHaveBeenCalled();
    expect(component.produtor.enderecoProdutor).toBeTruthy();
  });
});
