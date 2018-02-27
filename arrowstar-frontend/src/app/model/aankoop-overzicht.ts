import {AankoopCommand} from '../command/aankoop-command';
import {AankoopDto} from '../dto/aankoop-dto';
import {ProductDto} from '../dto/product-dto';
import {AankopenPerProduct} from './aankopen-per-product';

export class AankoopOverzicht {

  aankopenPerProduct: AankopenPerProduct[];
  totaalPrijs: number;

  commands: AankoopCommand[];

  constructor(producten: ProductDto[]) {
    this.aankopenPerProduct = [];
    this.commands = [];
    this.totaalPrijs = 0.00;
    producten.forEach(product => this.getAankopenVoorProduct(product.id, product.naam));
  }

  public addAankoop(aankoop: AankoopDto): void {
    let aankoopVoorProduct = this.getAankopenVoorProduct(aankoop.productId, aankoop.productOmschrijving);
    aankoopVoorProduct.addAankoop(aankoop.prijs);
    this.berekenTotaalPrijs();
  }

  public addProductAankoop(persoonId: number, productId: number, prijs: number): void {
    let aankoopVoorProduct = this.getAankopenVoorProduct(productId, '');
    aankoopVoorProduct.addAankoop(prijs);
    this.commands.push(new AankoopCommand(persoonId, productId, 'CREATE'));
    this.berekenTotaalPrijs();
  }

  public removeProductAankoop(persoonId: number, productId: number, prijs: number) {
    let aankoopVoorProduct = this.getAankopenVoorProduct(productId, '');
    aankoopVoorProduct.removeAankoop(prijs);
    this.commands.push(new AankoopCommand(persoonId, productId, 'DELETE'));
    this.berekenTotaalPrijs();
  }

  private berekenTotaalPrijs() {
    this.totaalPrijs = this.aankopenPerProduct.map(app => app.totaalPrijs).reduce((a, b) => a + b);
  }

  private getAankopenVoorProduct(productId: number, productOmschrijving: string): AankopenPerProduct {
    let aankoopVoorProduct = this.aankopenPerProduct.find(aankoopVoorProduct => aankoopVoorProduct.productId == productId);
    if (!aankoopVoorProduct) {
      aankoopVoorProduct = new AankopenPerProduct(productId, productOmschrijving);
      this.aankopenPerProduct.push(aankoopVoorProduct);
    }
    return aankoopVoorProduct;
  }

}
