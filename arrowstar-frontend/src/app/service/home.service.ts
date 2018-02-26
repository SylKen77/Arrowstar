import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Observable} from 'rxjs/Observable';
import {CreateGastCommand} from '../command/create-gast-command';
import {CreateLidCommand} from '../command/create-lid-command';
import {HomeKlantDto} from '../model/home-klant-dto';

@Injectable()
export class HomeService {

  private _klanten: BehaviorSubject<HomeKlantDto[]> = new BehaviorSubject([]);
  public klanten = this._klanten.asObservable();

  constructor(private httpCient: HttpClient) {
  }

  public loadKlanten(): Observable<HomeKlantDto[]> {
    this.httpCient.get('/api/kassa/klanten')
      .subscribe(
        data => this._klanten.next(data as HomeKlantDto[]),
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
