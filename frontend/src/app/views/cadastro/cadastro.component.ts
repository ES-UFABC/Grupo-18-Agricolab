import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';

export interface FormInput {
  name: string;
  label: string;
  type: string;
  value: string;
}

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent implements OnInit {
  showStartForm: boolean = true;
  showConsumidorForm: boolean = false;
  showProdutorForm: boolean = false;

  constructor(
    private titleService: Title
  ) { 
    this.titleService.setTitle("Cadastro - Agricolab");
  }

  ngOnInit(): void {
  }

}
