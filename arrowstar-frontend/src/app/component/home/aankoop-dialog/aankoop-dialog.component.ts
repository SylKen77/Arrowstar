import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {HomeKlantDto} from '../../../dto/home-klant-dto';
import {KlantType} from '../../../dto/klant-type';
import {AankoopOverzicht} from '../../../model/aankoop-overzicht';
import {BarService} from '../../../service/bar.service';
import {HomeService} from '../../../service/home.service';

@Component({
  selector: 'app-aankoop-dialog',
  templateUrl: './aankoop-dialog.component.html',
  styleUrls: ['./aankoop-dialog.component.css']
})
export class AankoopDialogComponent implements OnInit {

  public aankoopOverzicht: AankoopOverzicht;

  constructor(public dialogRef: MatDialogRef<AankoopDialogComponent>, @Inject(MAT_DIALOG_DATA) public klant: HomeKlantDto, public barService: BarService, public homeService: HomeService) {
    this.aankoopOverzicht = new AankoopOverzicht(this.barService.producten);
  }

  ngOnInit() {
    this.klant.aankopen.forEach(aankoop => this.aankoopOverzicht.addAankoop(aankoop));
  }

  ok() {
    this.processAankopen();
    this.dialogRef.close('ok');
  }

  public addAankoop(productId: number) {
    let product = this.barService.getProduct(productId);
    this.aankoopOverzicht.addProductAankoop(this.klant.persoonId, product.id, this.klant.type == KlantType.LID ? product.prijsLid : product.prijsGast);
  }

  public removeAankoop(productId: number) {
    let product = this.barService.getProduct(productId);
    this.aankoopOverzicht.removeProductAankoop(this.klant.persoonId, product.id, this.klant.type == KlantType.LID ? product.prijsLid : product.prijsGast);
  }

  private processAankopen() {
    if (this.aankoopOverzicht.commands) {
      this.homeService.processAankopen(this.aankoopOverzicht.commands);
    }
  }

}
