import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CadastroService } from 'src/app/service/cadastro.service';
import { setUsuario } from '../../login/login.component';

@Component({
  selector: 'app-apagar',
  templateUrl: './apagar.component.html',
  styleUrls: ['./apagar.component.scss']
})
export class ApagarComponent implements OnInit {
  user = setUsuario();
  
  constructor(
    public cadastroService: CadastroService,
    public router: Router
  ) { }

  ngOnInit(): void {
  }

  apagar() {
    this.cadastroService.deleteConsumidor(Number(this.user.idUsuario)).subscribe(data => {
      this.router.navigate(['/']);
    })
  }
}
