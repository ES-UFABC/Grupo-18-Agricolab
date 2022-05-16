import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { ProdutoService } from 'src/app/service/produtos.service';
import { ProdutoServiceMock } from 'src/app/service/produtos.service.mock';

import { CadastrarProdutosComponent } from './cadastrar-produtos.component';

describe('CadastrarProdutosComponent', () => {
  let component: CadastrarProdutosComponent;
  let fixture: ComponentFixture<CadastrarProdutosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastrarProdutosComponent ],
      imports: [ ReactiveFormsModule ],
      providers: [
        { provide: ProdutoService, useClass: ProdutoServiceMock },
      ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastrarProdutosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
