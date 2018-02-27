import { Component, OnInit } from '@angular/core';
import {HomeKlantDto} from '../../dto/home-klant-dto';
import {BarService} from '../../service/bar.service';
import {HomeService} from '../../service/home.service';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(public kassaHomeService: HomeService, public barService: BarService) {
  }

  ngOnInit() {
    this.kassaHomeService.loadKlanten();
    this.barService.loadProducten();
  }

  openAankoopDialog(klant: HomeKlantDto) {

  }

}
