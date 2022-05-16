import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { CadastroService } from 'src/app/service/cadastro.service';
import { CadastroServiceMock } from 'src/app/service/cadastro.service.mock';
import { GeoApiService } from 'src/app/service/geo-api.service';
import { GeoApiServiceMock } from 'src/app/service/geo-api.service.mock';

import { CadastroProdutorComponent } from './cadastro-produtor.component';

describe('CadastroProdutorComponent', () => {
  let component: CadastroProdutorComponent;
  let fixture: ComponentFixture<CadastroProdutorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroProdutorComponent ],
      imports: [ ReactiveFormsModule ],
      providers: [
        { provide: CadastroService, useClass: CadastroServiceMock },
        { provide: GeoApiService, useClass: GeoApiServiceMock },
      ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroProdutorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
