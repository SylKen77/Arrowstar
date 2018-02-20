import {Component, Input, OnInit} from '@angular/core';
import {KassaHomeKlantDto} from "../../../../model/kassa-home-klant-dto";

@Component({
  selector: 'klant-card',
  templateUrl: './klant-card.component.html',
  styleUrls: ['./klant-card.component.scss']
})
export class KlantCardComponent implements OnInit {

  @Input("klant") public klant: KassaHomeKlantDto;

  constructor() { }

  ngOnInit() {
  }

}
