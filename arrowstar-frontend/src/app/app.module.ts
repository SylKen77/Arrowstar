import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {
  MatAutocompleteModule,
  MatButtonModule, MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule, MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule, MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule, MatStepperModule, MatTableModule, MatTabsModule,
  MatToolbarModule,
  MatTooltipModule
} from '@angular/material';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CreateKlantCardComponent} from './component/home/create-klant-card/create-klant-card.component';
import {CreateKlantDialogComponent} from './component/home/create-klant-dialog/create-klant-dialog.component';
import {KlantCardComponent} from './component/home/klant-card/klant-card.component';
import {BarService} from './service/bar.service';
import {HomeService} from './service/home.service';
import {BarComponent} from './component/bar/bar.component';
import { ProductCardComponent } from './component/bar/product-card/product-card.component';
import { HomeComponent } from './component/home/home.component';
import { KassaComponent } from './component/kassa/kassa.component';
import { AankoopDialogComponent } from './component/home/aankoop-dialog/aankoop-dialog.component';
import { AfrekenDialogComponent } from './component/home/afreken-dialog/afreken-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    KlantCardComponent,
    CreateKlantCardComponent,
    CreateKlantDialogComponent,
    BarComponent,
    ProductCardComponent,
    HomeComponent,
    KassaComponent,
    AankoopDialogComponent,
    AfrekenDialogComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule
  ],
  entryComponents: [CreateKlantDialogComponent, AankoopDialogComponent, AfrekenDialogComponent],
  providers: [HomeService, BarService],
  bootstrap: [AppComponent]
})
export class AppModule {
}

