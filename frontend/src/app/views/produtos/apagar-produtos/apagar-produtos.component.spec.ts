import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { ProdutoService } from 'src/app/service/produtos.service';
import { ProdutoServiceMock } from 'src/app/service/produtos.service.mock';

import { ApagarProdutosComponent } from './apagar-produtos.component';

describe('ApagarProdutosComponent', () => {
  let component: ApagarProdutosComponent;
  let fixture: ComponentFixture<ApagarProdutosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApagarProdutosComponent ],
      providers: [
        { provide: ProdutoService, useClass: ProdutoServiceMock },
      ],
      imports: [ RouterModule.forRoot([]) ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApagarProdutosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
