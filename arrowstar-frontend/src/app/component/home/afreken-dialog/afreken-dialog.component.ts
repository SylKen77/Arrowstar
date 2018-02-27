import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {CreateAfrekeningCommand} from '../../../command/create-afrekening-command';
import {AankoopOverzicht} from '../../../model/aankoop-overzicht';
import {BarService} from '../../../service/bar.service';
import {HomeService} from '../../../service/home.service';

@Component({
  selector: 'app-afreken-dialog',
  templateUrl: './afreken-dialog.component.html',
  styleUrls: ['./afreken-dialog.component.css']
})
export class AfrekenDialogComponent implements OnInit {

  public aankoopOverzicht: AankoopOverzicht;
  public gegeven: number;
  public terugBedrag: number;

  public okActief: boolean = false;

  constructor(public dialogRef: MatDialogRef<AfrekenDialogComponent>, @Inject(MAT_DIALOG_DATA) public klantId: number, private barService: BarService, private homeService: HomeService) {
    this.aankoopOverzicht = new AankoopOverzicht(this.barService.producten);
  }

  ngOnInit() {
    this.homeService.loadKlant(this.klantId).then(klant => {
      console.log('klant loaded');
      klant.aankopen.forEach(aankoop => this.aankoopOverzicht.addAankoop(aankoop));
    });
  }

  berekenTerugBedrag() {
    this.terugBedrag = Math.max(0, this.gegeven - this.aankoopOverzicht.totaalPrijs);
    this.okActief = this.gegeven >= this.aankoopOverzicht.totaalPrijs;
  }

  ok() {
    this.homeService.afrekenen(new CreateAfrekeningCommand(this.klantId)).then(() => this.dialogRef.close('ok'));
  }

}
