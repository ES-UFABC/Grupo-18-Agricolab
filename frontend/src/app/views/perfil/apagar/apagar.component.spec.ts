import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { CadastroService } from 'src/app/service/cadastro.service';
import { CadastroServiceMock } from 'src/app/service/cadastro.service.mock';

import { ApagarComponent } from './apagar.component';

describe('ApagarComponent', () => {
  let component: ApagarComponent;
  let fixture: ComponentFixture<ApagarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApagarComponent ],
      providers: [
        HttpClientModule,
        { provide: CadastroService, useValue: CadastroServiceMock }
      ],
      imports: [ RouterModule.forRoot([]), ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApagarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
