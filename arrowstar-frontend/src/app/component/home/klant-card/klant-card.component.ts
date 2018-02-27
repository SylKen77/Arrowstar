import {Component, Input, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material';
import {HomeKlantDto} from '../../../dto/home-klant-dto';
import {AankoopOverzicht} from '../../../model/aankoop-overzicht';
import {BarService} from '../../../service/bar.service';
import {AankoopDialogComponent} from '../aankoop-dialog/aankoop-dialog.component';
import {CreateKlantDialogComponent} from '../create-klant-dialog/create-klant-dialog.component';

@Component({
  selector: 'klant-card',
  templateUrl: './klant-card.component.html',
  styleUrls: ['./klant-card.component.scss']
})
export class KlantCardComponent implements OnInit {

  @Input('klant') public klant: HomeKlantDto;
  public aankoopOverzicht: AankoopOverzicht;


  constructor(public dialog: MatDialog, private barService: BarService) {
    this.aankoopOverzicht = new AankoopOverzicht(this.barService.producten);
  }

  ngOnInit() {
    this.klant.aankopen.forEach(aankoop => this.aankoopOverzicht.addAankoop(aankoop));
  }

  openDialog(): void {
    let dialogRef = this.dialog.open(AankoopDialogComponent, {
      data: this.klant,
      width: '400px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('dialog closed: ' + result);
    });
  }

}
