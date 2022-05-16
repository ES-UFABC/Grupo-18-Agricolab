import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ProdutoService } from 'src/app/service/produtos.service';
import { ProdutoServiceMock } from 'src/app/service/produtos.service.mock';

import { EditarProdutosComponent } from './editar-produtos.component';

describe('EditarProdutosComponent', () => {
  let component: EditarProdutosComponent;
  let fixture: ComponentFixture<EditarProdutosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarProdutosComponent ],
      imports: [ RouterModule.forRoot([]), ReactiveFormsModule ],
      providers: [
        { provide: ProdutoService, useClass: ProdutoServiceMock },
      ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarProdutosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
