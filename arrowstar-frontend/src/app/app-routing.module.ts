import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BarComponent} from './component/bar/bar.component';
import {KassaHomeComponent} from "./component/kassa/kassa-home/kassa-home.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: '/kassa-home',
    pathMatch: 'full'
  },
  {
    path: 'kassa-home',
    component: KassaHomeComponent
  },
  {
    path: 'bar',
    component: BarComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}
