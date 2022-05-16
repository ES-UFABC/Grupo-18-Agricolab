import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html',
  styleUrls: ['./produtos.component.scss']
})
export class ProdutosComponent implements OnInit {

  constructor(
    public router: Router,
    private titleService: Title
  ) {
    this.titleService.setTitle("Produtos - Agricolab");
   }

  ngOnInit(): void {
    this.router.navigateByUrl('produtos/listar');
  }

}
