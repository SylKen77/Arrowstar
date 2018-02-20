import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {CreateGastCommand} from '../../../../command/create-gast-command';
import {CreateLidCommand} from '../../../../command/create-lid-command';
import {KlantType} from '../../../../model/klant-type';
import {KassaHomeService} from '../../../../service/kassa-home.service';

@Component({
  selector: 'app-create-klant-dialog',
  templateUrl: './create-klant-dialog.component.html',
  styleUrls: ['./create-klant-dialog.component.css']
})
export class CreateKlantDialogComponent implements OnInit {

  public naam: string;
  public voornaam: string;
  public klantType: KlantType = KlantType.GAST;

  public klantTypeEnum = KlantType;

  constructor(public dialogRef: MatDialogRef<CreateKlantDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: any, private kassaHomeService: KassaHomeService) {
  }

  ngOnInit() {
  }

  ok() {
    this.createKlant();
    this.dialogRef.close('ok');
  }

  cancel() {
    this.dialogRef.close('cancel');
  }

  private createKlant() {
    switch (this.klantType) {
      case KlantType.GAST: return this.createGast();
      case KlantType.LID: return this.createLid();
    }
  }

  private createGast() {
    let createGastCommand: CreateGastCommand = {
      naam: this.naam,
      voornaam: this.voornaam
    };
    this.kassaHomeService.createGast(createGastCommand);
  }

  private createLid() {
    let createLidCommand: CreateLidCommand = {
      naam: this.naam,
      voornaam: this.voornaam,
      isZichtbaarOpHomeScreen: true
    };
    this.kassaHomeService.createLid(createLidCommand);
  }
}
