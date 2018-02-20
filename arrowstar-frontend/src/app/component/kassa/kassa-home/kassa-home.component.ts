import {Component, OnInit} from '@angular/core';
import {KassaHomeService} from '../../../service/kassa-home.service';

@Component({
  selector: 'app-kassa-home',
  templateUrl: './kassa-home.component.html',
  styleUrls: ['./kassa-home.component.scss']
})
export class KassaHomeComponent implements OnInit {

  constructor(public kassaHomeService: KassaHomeService) {
  }

  ngOnInit() {
    this.kassaHomeService.loadKlanten();
  }

}
