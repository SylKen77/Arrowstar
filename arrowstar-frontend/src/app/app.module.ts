import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {MatToolbarModule} from '@angular/material';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {KassaHomeKlantComponent} from './component/kassa/kassa-home/kassa-home-klant/kassa-home-klant.component';
import {KassaHomeComponent} from './component/kassa/kassa-home/kassa-home.component';
import {ToolbarComponent} from './component/toolbar/toolbar.component';
import {KassaHomeService} from './service/kassa-home.service';

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    KassaHomeComponent,
    KassaHomeKlantComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    HttpClientModule
  ],
  providers: [KassaHomeService],
  bootstrap: [AppComponent]
})
export class AppModule {
}

