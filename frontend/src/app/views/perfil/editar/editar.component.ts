import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormInput } from 'src/app/components/cadastro-produtor/cadastro-produtor.component';
import { Consumidor } from 'src/app/model/consumidor.model';
import { CadastroService } from 'src/app/service/cadastro.service';
import { GeoApiService } from 'src/app/service/geo-api.service';
import { setUsuario, UserSession } from '../../login/login.component';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.scss']
})
export class EditarComponent implements OnInit {
  user: UserSession = setUsuario();
  cadastroForm: FormGroup;
  
  formInputs: FormInput[] = [
    { name: 'nome', label: 'Nome Completo', type: 'text', value: '', obrigatorio: true },
    { name: 'email', label: 'Email', type: 'email', value: '', obrigatorio: true },
    { name: 'senha', label: 'Senha', type: 'password', value: '', obrigatorio: true },
    { name: 'telefone', label: 'Telefone', type: 'tel', value: '', obrigatorio: false },
    { name: 'cpf', label: 'CPF', type: 'text', value: '', obrigatorio: false },
    { name: 'enderecoRua', label: 'Rua', type: 'text', value: '', obrigatorio: true },
    { name: 'enderecoNumero', label: 'Número', type: 'text', value: '', obrigatorio: false },
    { name: 'enderecoComplemento', label: 'Complemento', type: 'text', value: '', obrigatorio: false },
    { name: 'enderecoBairro', label: 'Bairro', type: 'text', value: '', obrigatorio: true },
    { name: 'enderecoCidade', label: 'Cidade', type: 'text', value: '', obrigatorio: true },
    { name: 'enderecoEstado', label: 'Estado', type: 'text', value: '', obrigatorio: true },
  ]

  showForm: boolean = true;
  isFormSucess: boolean = false;

  constructor(
    public formBuilder: FormBuilder,
    public cadastroService: CadastroService,
    public geoApiService: GeoApiService,
  ) { }

  ngOnInit(): void {
    this.construirForm();
    this.buscaUsuario(this.user.idUsuario)
  }

  construirForm() {
    this.cadastroForm = this.formBuilder.group({
      nome: ['', [Validators.required]],
      email: ['', [Validators.email, Validators.required]],
      senha: ['', [Validators.required]],
      telefone: ['', [Validators.nullValidator]],
      cpf: ['', [Validators.nullValidator]],
      enderecoRua: ['', [Validators.required]],
      enderecoNumero: ['', [Validators.nullValidator]],
      enderecoComplemento: ['', [Validators.nullValidator]],
      enderecoBairro: ['', [Validators.required]],
      enderecoCidade: ['', [Validators.required]],
      enderecoEstado: ['', [Validators.required]],
    });
  }

  buscaUsuario(idUsuario: string | null) {
    this.cadastroService.getConsumidor(Number(idUsuario)).subscribe(data => {
      console.log(data);

      const dadosConvertidos = this.converterDadosRetorno(data);

      this.formInputs.forEach(input => {
        this.cadastroForm.get(input.name)?.setValue(dadosConvertidos[input.name]);
      })
    })
  }

  converterDadosRetorno(dadosUsuario: Consumidor) {
    const enderecoArray = dadosUsuario.enderecoConsumidor.split(';');

    return {
      nome: this.validaString(dadosUsuario.nomeConsumidor),
      email: this.validaString(dadosUsuario.emailConsumidor),
      senha: this.validaString(dadosUsuario.senhaConsumidor),
      telefone: this.validaString(dadosUsuario.telefoneConsumidor),
      cpf: this.validaString(dadosUsuario.cpfConsumidor),
      enderecoComplemento: this.validaString(dadosUsuario.complementoEnderecoconsumidor),
      enderecoRua: this.validaString(enderecoArray[0]),
      enderecoNumero: this.validaString(enderecoArray[1]),
      enderecoBairro: this.validaString(enderecoArray[2]),
      enderecoCidade: this.validaString(enderecoArray[3]),
      enderecoEstado: this.validaString(enderecoArray[4]),
    }
  }

  validaString(value: string) {
    return value ? value : '';
  }

  atualizaCadastro(event){
    if(!this.cadastroForm.valid) return;

    const rua = this.cadastroForm.get('enderecoRua')?.value;
    const numero = this.cadastroForm.get('enderecoNumero')?.value;
    const bairro = this.cadastroForm.get('enderecoBairro')?.value;
    const cidade = this.cadastroForm.get('enderecoCidade')?.value;
    const estado = this.cadastroForm.get('enderecoEstado')?.value;

    const endereco = 
      (rua ? rua : '') + ';' +
      (numero ? numero : '') + ';' +
      (bairro ? bairro : '') + ';' +
      (cidade ? cidade : '') + ';' +
      (estado ? estado : '');

    const params = {
      nomeConsumidor: this.cadastroForm.get('nome')?.value,
      emailConsumidor: this.cadastroForm.get('email')?.value,
      senhaConsumidor: this.cadastroForm.get('senha')?.value,
      telefoneConsumidor: this.cadastroForm.get('telefone')?.value,
      cpfConsumidor: this.cadastroForm.get('cpf')?.value,
      complementoEnderecoconsumidor: this.cadastroForm.get('enderecoComplemento')?.value,
      enderecoConsumidor: endereco,
      latitudeConsumidor: '',
      longitudeConsumidor: '',
    };

    const enderecoGeo =
      (numero ? numero + ' ' : '') +
      (rua ? rua + ', ' : '') +
      (bairro ? bairro + ', ' : '') +
      (cidade ? cidade + ', ' : '') +
      (estado ? estado + ', ' : '') + 'Brasil';

    this.geoApiService.getGeocoding(enderecoGeo).subscribe(geoData => {

      if(geoData && geoData.data && geoData.data.length > 0) {
        params.latitudeConsumidor = geoData.data[0].latitude;
        params.longitudeConsumidor = geoData.data[0].longitude;
      }
  
      this.cadastroService.putConsumidor(params, this.user.idUsuario).subscribe(data => {
        this.showForm = false;
        this.isFormSucess = true;
      },
      err => {
        this.showForm = false;
        this.isFormSucess = false;
      });
    },
    err => {
      this.showForm = false;
      this.isFormSucess = false;
    });

  }

}
