import { Component, OnInit } from '@angular/core';
import { Produto } from 'src/app/model/produto.model';
import { CadastroService } from 'src/app/service/cadastro.service';
import { setUsuario, UserSession } from '../../login/login.component';

@Component({
  selector: 'app-listar-produtos',
  templateUrl: './listar-produtos.component.html',
  styleUrls: ['./listar-produtos.component.scss']
})
export class ListarProdutosComponent implements OnInit {
  user: UserSession = setUsuario();
  produtosArray: Produto[] = [];

  constructor(
    public cadastroService: CadastroService,
  ) { }

  ngOnInit(): void {
    this.listaProdutos(this.user.idUsuario);
  }

  listaProdutos(idUsuario: string | null) {
    this.cadastroService.getProdutor(Number(idUsuario)).subscribe(data => {
      this.produtosArray = data.produtos ? data.produtos : [];

      this.produtosArray = [
        {
          "idProduto": 5,
          "nomeProduto": "alface",
          "quantidadeProduto": 200,
          "valorProduto": 20.00
        },
        {
          "idProduto": 6,
          "nomeProduto": "tomate",
          "quantidadeProduto": 100,
          "valorProduto": 30.00
        }
      ];
    })
  }
}
