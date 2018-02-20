import {Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {KassaHomeKlantDto} from "../model/kassa-home-klant-dto";
import {Observable} from "rxjs/Observable";
import {KlantType} from "../model/klant-type";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class KassaHomeService {

  private _klanten: BehaviorSubject<KassaHomeKlantDto[]> = new BehaviorSubject([]);
  public klanten = this._klanten.asObservable();

  constructor(private httpCient: HttpClient) {
  }

  public loadKlanten(): Observable<KassaHomeKlantDto[]> {
    this.httpCient.get('/api/kassa/klanten').subscribe(
      data => this._klanten.next(data as KassaHomeKlantDto[]),
      err => console.log(err));
    return this.klanten;
  }

  private buildKlant(id: number, naam: string): KassaHomeKlantDto {
    let klant: KassaHomeKlantDto = {
      id: id,
      type: KlantType.LID,
      naam: naam,
      aankopen: []
    };
    return klant;
  }
}
