import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BarComponent} from './component/bar/bar.component';
import {HomeComponent} from './component/home/home.component';
import {KassaComponent} from './component/kassa/kassa.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'bar',
    component: BarComponent
  },
  {
    path: 'kassa',
    component: KassaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}
