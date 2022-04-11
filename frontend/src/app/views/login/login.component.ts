import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CadastroService } from 'src/app/service/cadastro.service';
import { LoginService } from 'src/app/service/login.service';

export interface UserSession {
  idUsuario: string | null;
  nomeUsuario: string | null;
  emailUsuario: string | null;
}

export function setUsuario(): UserSession {
  return {
    idUsuario: window.localStorage.getItem('idUsuario'),
    nomeUsuario: window.localStorage.getItem('nomeUsuario'),
    emailUsuario: window.localStorage.getItem('emailUsuario'),
  }
}

export function logoutUsuario() {
  window.localStorage.removeItem('idUsuario');
  window.localStorage.removeItem('nomeUsuario');
  window.localStorage.removeItem('emailUsuario');
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  isUserValid: boolean = true;

  constructor(
    public router: Router,
    public formBuilder: FormBuilder,
    public cadastroService: CadastroService,
    public loginService: LoginService,

  ) { }

  ngOnInit(): void {
    this.construirForm();
  }

  construirForm() {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.email, Validators.required]],
      senha: ['', [Validators.required]],
    });
  }

  validaLogin(loginForm: FormGroup) {
    return !(loginForm.get('email')?.valid && loginForm.get('senha')?.valid);
  }

  login(){
    if(this.validaLogin(this.loginForm)) return;
    
    const params = {
      emailConsumidor: this.loginForm.get('email')?.value,
      senhaConsumidor: this.loginForm.get('senha')?.value,
    };

    this.loginService.loginConsumidor(params).subscribe(data => {
      window.localStorage.setItem('idUsuario', data.idConsumidor.toString());
      window.localStorage.setItem('nomeUsuario', data.nomeConsumidor);
      window.localStorage.setItem('emailUsuario', data.emailConsumidor);

      this.router.navigateByUrl('/perfil');
      window.location.reload();
    },
    err => {
      this.isUserValid = false;
    })
  }
}
