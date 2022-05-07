import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './views/cadastro/cadastro.component';
import { ContatoComponent } from './views/contato/contato.component';
import { HomeComponent } from './views/home/home.component';
import { LoginComponent } from './views/login/login.component';
import { MapaComponent } from './views/mapa/mapa.component';
import { PedidosComponent } from './views/pedidos/pedidos.component';
import { ApagarComponent } from './views/perfil/apagar/apagar.component';
import { EditarComponent } from './views/perfil/editar/editar.component';
import { PerfilComponent } from './views/perfil/perfil.component';
import { ApagarProdutosComponent } from './views/produtos/apagar-produtos/apagar-produtos.component';
import { CadastrarProdutosComponent } from './views/produtos/cadastrar-produtos/cadastrar-produtos.component';
import { EditarProdutosComponent } from './views/produtos/editar-produtos/editar-produtos.component';
import { ListarProdutosComponent } from './views/produtos/listar-produtos/listar-produtos.component';
import { ProdutosComponent } from './views/produtos/produtos.component';
import { TimeComponent } from './views/time/time.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'cadastro',
    component: window.localStorage.getItem('idUsuario') ? PerfilComponent : CadastroComponent
  },
  {
    path: 'login',
    component: window.localStorage.getItem('idUsuario') ? PerfilComponent : LoginComponent
  },
  {
    path: 'perfil',
    component: window.localStorage.getItem('idUsuario') ? PerfilComponent : LoginComponent,
  },
  {
    path: 'perfil/editar',
    component: window.localStorage.getItem('idUsuario') ? EditarComponent : LoginComponent,
  },
  {
    path: 'perfil/apagar',
    component: window.localStorage.getItem('idUsuario') ? ApagarComponent : LoginComponent,
  },
  {
    path: 'produtos',
    component: ProdutosComponent,
    // component: window.localStorage.getItem('idUsuario') ? ProdutosComponent : LoginComponent,
    children: [
      {
        path: 'listar',
        component: ListarProdutosComponent
      },
      {
        path: 'cadastro',
        component: CadastrarProdutosComponent
      },
      {
        path: 'editar',
        component: EditarProdutosComponent
      },
      {
        path: 'apagar',
        component: ApagarProdutosComponent
      },
    ]
  },
  {
    path: 'mapa',
    component: MapaComponent
  },
  {
    path: 'pedidos/:id',
    component: PedidosComponent
  },
  {
    path: 'time',
    component: TimeComponent
  },
  {
    path: 'contato',
    component: ContatoComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {scrollPositionRestoration: 'enabled', onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
