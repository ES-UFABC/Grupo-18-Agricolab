import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CadastroService } from 'src/app/service/cadastro.service';
import { CadastroServiceMock } from 'src/app/service/cadastro.service.mock';
import { LoginService } from 'src/app/service/login.service';
import { LoginServiceMock } from 'src/app/service/login.service.mock';

import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [ RouterModule.forRoot([]), ReactiveFormsModule ],
      providers: [
        { provide: CadastroService, useClass: CadastroServiceMock },
        { provide: LoginService, useClass: LoginServiceMock },
      ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
