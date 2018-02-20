import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Observable} from 'rxjs/Observable';
import {CreateGastCommand} from '../command/create-gast-command';
import {CreateLidCommand} from '../command/create-lid-command';
import {KassaHomeKlantDto} from '../model/kassa-home-klant-dto';

@Injectable()
export class KassaHomeService {

  private _klanten: BehaviorSubject<KassaHomeKlantDto[]> = new BehaviorSubject([]);
  public klanten = this._klanten.asObservable();

  constructor(private httpCient: HttpClient) {
  }

  public loadKlanten(): Observable<KassaHomeKlantDto[]> {
    this.httpCient.get('/api/kassa/klanten')
      .subscribe(
        data => this._klanten.next(data as KassaHomeKlantDto[]),
        err => console.log(err));
    return this.klanten;
  }

  public createLid(createLidCommand: CreateLidCommand) {
    this.httpCient.post('/api/lid/create', createLidCommand)
      .subscribe(
        () => this.loadKlanten(),
        err => console.log(err));
  }

  public createGast(createGastCommand: CreateGastCommand) {
    this.httpCient.post('/api/gast/create', createGastCommand)
      .subscribe(
        () => this.loadKlanten(),
        err => console.log(err));
  }

}
