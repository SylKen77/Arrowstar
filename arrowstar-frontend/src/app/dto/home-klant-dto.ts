import {KlantType} from "./klant-type";
import {AankoopDto} from "./aankoop-dto";

export interface HomeKlantDto {

  persoonId: number;
  type: KlantType;
  naam: string;
  aankopen: AankoopDto[];


}
