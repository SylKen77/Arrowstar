import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Observable} from 'rxjs/Observable';
import {map} from 'rxjs/operators';
import {AankoopCommand} from '../command/aankoop-command';
import {CreateAfrekeningCommand} from '../command/create-afrekening-command';
import {CreateGastCommand} from '../command/create-gast-command';
import {CreateLidCommand} from '../command/create-lid-command';
import {HomeKlantDto} from '../dto/home-klant-dto';

@Injectable()
export class HomeService {

  private _klanten: BehaviorSubject<HomeKlantDto[]> = new BehaviorSubject([]);
  public klanten = this._klanten.asObservable();

  constructor(private httpCient: HttpClient) {
  }

  public loadKlant(persoonId: number): Promise<HomeKlantDto> {
    return this.httpCient
      .get('/api/kassa/klant/' + persoonId)
      .pipe(map(data => data as HomeKlantDto))
      .toPromise();
  }

  public loadKlanten(): Promise<boolean> {
    return new Promise((resolve, reject) => {
      this.httpCient.get('/api/kassa/klanten')
        .subscribe(
          data => {
            this._klanten.next(data as HomeKlantDto[]);
            resolve(true);
          }
          ,
          err => reject(err));
    });
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

  public processAankopen(aankopen: AankoopCommand[]): Promise<boolean> {
    return this.processAankopenZonderLoadKlanten(aankopen)
      .then(() => this.loadKlanten());
  }

  private processAankopenZonderLoadKlanten(aankopen: AankoopCommand[]): Promise<boolean> {
    return new Promise((resolve, reject) =>
      this.httpCient.post('/api/kassa/aankopen/process', aankopen)
        .subscribe(
          () => resolve(true),
          err => reject(err)));
  }

  public afrekenen(createAfrekeningCommand: CreateAfrekeningCommand): Promise<boolean> {
    return this.afrekenenZonderLoadKlanten(createAfrekeningCommand)
      .then(() => this.loadKlanten());
  }

  private afrekenenZonderLoadKlanten(createAfrekeningCommand: CreateAfrekeningCommand): Promise<boolean> {
    return new Promise((resolve, reject) =>
      this.httpCient.post('/api/kassa/afrekenen', createAfrekeningCommand)
        .subscribe(
          () => resolve(true),
          err => reject(err)));
  }

}
