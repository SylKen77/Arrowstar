import {Component, Input, OnInit} from '@angular/core';
import {KassaHomeKlantDto} from "../../../../model/kassa-home-klant-dto";

@Component({
  selector: 'kassa-home-klant',
  templateUrl: './kassa-home-klant.component.html',
  styleUrls: ['./kassa-home-klant.component.scss']
})
export class KassaHomeKlantComponent implements OnInit {

  @Input("klant") public klant: KassaHomeKlantDto;

  constructor() { }

  ngOnInit() {
  }

}
