import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { CadastroService } from 'src/app/service/cadastro.service';
import { CadastroServiceMock } from 'src/app/service/cadastro.service.mock';
import { GeoApiService } from 'src/app/service/geo-api.service';
import { GeoApiServiceMock } from 'src/app/service/geo-api.service.mock';

import { CadastroConsumidorComponent } from './cadastro-consumidor.component';

describe('CadastroConsumidorComponent', () => {
  let component: CadastroConsumidorComponent;
  let fixture: ComponentFixture<CadastroConsumidorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroConsumidorComponent ],
      imports: [ ReactiveFormsModule ],
      providers: [
        { provide: CadastroService, useClass: CadastroServiceMock },
        { provide: GeoApiService, useClass: GeoApiServiceMock },
      ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroConsumidorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
