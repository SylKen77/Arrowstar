import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {toPromise} from 'rxjs/operator/toPromise';
import {filter, map} from 'rxjs/operators';
import {ProductDto} from '../dto/product-dto';

@Injectable()
export class BarService {

  public producten: ProductDto[] = [];

  constructor(private httpCient: HttpClient) {
  }

  public loadProducten(): ProductDto[]{
    this.httpCient.get('/api/kassa/producten')
      .subscribe(
        data => this.producten = (data as ProductDto[]),
        err => console.log(err));
    return this.producten;
  }

  public getProduct(productId: number) {
    return this.producten.find(product => product.id == productId);
  }

}
