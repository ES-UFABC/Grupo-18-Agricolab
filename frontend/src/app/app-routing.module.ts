import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './views/cadastro/cadastro.component';
import { ContatoComponent } from './views/contato/contato.component';
import { HomeComponent } from './views/home/home.component';
import { LoginComponent } from './views/login/login.component';
import { MapaComponent } from './views/mapa/mapa.component';
import { TimeComponent } from './views/time/time.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'cadastro',
    component: CadastroComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'mapa',
    component: HomeComponent
    // component: MapaComponent
  },
  {
    path: 'time',
    component: HomeComponent
    // component: TimeComponent
  },
  {
    path: 'contato',
    component: HomeComponent
    // component: ContatoComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {scrollPositionRestoration: 'enabled', onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
