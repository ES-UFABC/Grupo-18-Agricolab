import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CadastroService } from 'src/app/service/cadastro.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(
    public formBuilder: FormBuilder,
    public cadastroService: CadastroService,
  ) { }

  ngOnInit(): void {
    this.construirForm();
  }

  construirForm() {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required]],
      senha: ['', [Validators.required]],
    });
  }

  teste(event){
    console.log(event)
    console.log(this.loginForm.valid)
    console.log(this.loginForm.get('email')?.valid)

    this.cadastroService.getProdutores().subscribe(data => console.log(data));
    this.cadastroService.getProdutor(1).subscribe(data => console.log(data));
  }
}
