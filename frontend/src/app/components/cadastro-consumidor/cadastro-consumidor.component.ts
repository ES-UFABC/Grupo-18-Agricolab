import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { onErrorResumeNext } from 'rxjs/operators';
import { CadastroService } from 'src/app/service/cadastro.service';

export interface FormInput {
  name: string;
  label: string;
  type: string;
  value: string;
  obrigatorio: boolean;
}

@Component({
  selector: 'app-cadastro-consumidor',
  templateUrl: './cadastro-consumidor.component.html',
  styleUrls: ['./cadastro-consumidor.component.scss']
})
export class CadastroConsumidorComponent implements OnInit {
  cadastroForm: FormGroup;
  
  formInputs: FormInput[] = [
    { name: 'nome', label: 'Nome Completo', type: 'text', value: '', obrigatorio: true },
    { name: 'email', label: 'Email', type: 'email', value: '', obrigatorio: true },
    { name: 'telefone', label: 'Telefone', type: 'tel', value: '', obrigatorio: false },
    { name: 'cnpj', label: 'CNPJ', type: 'text', value: '', obrigatorio: false },
    { name: 'cpf', label: 'CPF', type: 'text', value: '', obrigatorio: false },
    { name: 'enderecoRua', label: 'Rua', type: 'text', value: '', obrigatorio: true },
    { name: 'enderecoNumero', label: 'Número', type: 'text', value: '', obrigatorio: false },
    { name: 'enderecoBairro', label: 'Bairro', type: 'text', value: '', obrigatorio: true },
    { name: 'enderecoCidade', label: 'Cidade', type: 'text', value: '', obrigatorio: true },
    { name: 'enderecoEstado', label: 'Estado', type: 'text', value: '', obrigatorio: true },
  ]

  qualInput: number = 0;
  inputFinal: number = this.formInputs.length - 1;
  campoInvalido: boolean | undefined = false;
  showForm: boolean = true;
  isFormSucess: boolean = false;

  constructor(
    public formBuilder: FormBuilder,
    public cadastroService: CadastroService,
  ) { }

  ngOnInit(): void {
    this.construirForm();
  }
  
  construirForm() {
    this.cadastroForm = this.formBuilder.group({
      nome: ['', [Validators.required]],
      email: ['', [Validators.email, Validators.required]],
      telefone: ['', [Validators.nullValidator]],
      cnpj: ['', [Validators.nullValidator]],
      cpf: ['', [Validators.nullValidator]],
      enderecoRua: ['', [Validators.required]],
      enderecoNumero: ['', [Validators.nullValidator]],
      enderecoBairro: ['', [Validators.required]],
      enderecoCidade: ['', [Validators.required]],
      enderecoEstado: ['', [Validators.required]],
    });
  }

  avancaForm() {
    if(this.validaInput(this.qualInput)) return;
    if(this.qualInput < this.inputFinal) this.qualInput++;
  }

  voltaForm(): void {
    if(this.qualInput > 0) {
      this.qualInput--;
      this.campoInvalido = false;
    }
  }

  validaInput(position: number): boolean {
    const input = this.formInputs[position];
    const isValid = !this.cadastroForm.get(input.name)?.valid;
    this.campoInvalido = isValid;

    return isValid;
  }

  isHidden(inputNumber: number) {
    return this.qualInput === inputNumber ? false : true;
  }

  cadastraConsumidor(event){
    console.log(event)

    const rua = this.cadastroForm.get('enderecoRua')?.value;
    const numero = this.cadastroForm.get('enderecoNumero')?.value;
    const bairro = this.cadastroForm.get('enderecoBairro')?.value;
    const cidade = this.cadastroForm.get('enderecoCidade')?.value;
    const estado = this.cadastroForm.get('enderecoEstado')?.value;

    // const endereco = `${rua ? rua : ''};${numero ? numero : ''};${bairro ? bairro : ''};${cidade ? cidade : ''};${estado ? estado : ''}`;
    const endereco = 
      (rua ? rua : '') + ';' +
      (numero ? numero : '') + ';' +
      (bairro ? bairro : '') + ';' +
      (cidade ? cidade : '') + ';' +
      (estado ? estado : '');

    const params = {
      nomeConsumidor: this.cadastroForm.get('nome')?.value,
      emailConsumidor: this.cadastroForm.get('email')?.value,
      telefoneConsumidor: this.cadastroForm.get('telefone')?.value,
      cnpjConsumidor: this.cadastroForm.get('cnpj')?.value,
      cpfConsumidor: this.cadastroForm.get('cpf')?.value,
      enderecoConsumidor: endereco,
    };

    this.cadastroService.postConsumidor(params).subscribe(data => {
      this.showForm = false;
      this.isFormSucess = true;
    },
    err => {
      this.showForm = false;
      this.isFormSucess = false;
    });
  }

}