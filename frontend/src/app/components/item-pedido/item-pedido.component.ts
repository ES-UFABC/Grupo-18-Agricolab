import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Produto } from 'src/app/model/produto.model';

@Component({
  selector: 'app-item-pedido',
  templateUrl: './item-pedido.component.html',
  styleUrls: ['./item-pedido.component.scss']
})
export class ItemPedidoComponent implements OnInit {
  @Input() produto: Produto;
  produtoForm: FormGroup;
  
  constructor(
    public formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.construirForm();
  }

  construirForm() {
    this.produtoForm = this.formBuilder.group({
      quantidade: [0, [Validators.nullValidator]],
    });
  }

  atualizaQtd() {
    console.log(this.produtoForm.value)
  }
}
