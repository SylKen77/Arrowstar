import {KlantType} from "./klant-type";
import {AankoopDto} from "./aankoop-dto";

export interface HomeKlantDto {

  id: number;
  type: KlantType;
  naam: string;
  aankopen: AankoopDto[];


}
