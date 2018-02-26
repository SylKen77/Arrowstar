import {Component, Input, OnInit} from '@angular/core';
import {HomeKlantDto} from "../../../model/home-klant-dto";

@Component({
  selector: 'klant-card',
  templateUrl: './klant-card.component.html',
  styleUrls: ['./klant-card.component.scss']
})
export class KlantCardComponent implements OnInit {

  @Input("klant") public klant: HomeKlantDto;

  constructor() { }

  ngOnInit() {
  }

}
