export class AankopenPerProduct {

  productId: number;
  productOmschrijving: string;
  aantal: number;
  totaalPrijs: number;

  constructor(productId: number, productOmschrijving: string) {
    this.productId = productId;
    this.productOmschrijving = productOmschrijving;
    this.aantal = 0;
    this.totaalPrijs = 0.0;
  }

  addAankoop(prijs: number) {
    this.aantal++;
    this.totaalPrijs += prijs;
  }

  removeAankoop(prijs: number) {
    if (this.aantal <= 0) return;
    this.aantal--;
    this.totaalPrijs -= prijs;
  }
}
