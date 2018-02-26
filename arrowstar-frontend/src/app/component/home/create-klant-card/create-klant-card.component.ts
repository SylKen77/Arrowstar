import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material';
import {CreateKlantDialogComponent} from '../create-klant-dialog/create-klant-dialog.component';

@Component({
  selector: 'create-klant-card',
  templateUrl: './create-klant-card.component.html',
  styleUrls: ['./create-klant-card.component.scss']
})
export class CreateKlantCardComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }

  openDialog(): void {
    let dialogRef = this.dialog.open(CreateKlantDialogComponent, {
      width: '400px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('dialog closed: ' + result);
    });
  }

}
