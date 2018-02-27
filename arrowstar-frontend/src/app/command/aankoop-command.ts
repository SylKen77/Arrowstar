export class AankoopCommand {

  persoonId: number;
  productId: number;
  type: string;

  constructor(persoonId: number, productId: number, type: string) {
    this.persoonId = persoonId;
    this.productId = productId;
    this.type = type;
  }

}
