import {KlantType} from "./klant-type";
import {AankoopDto} from "./aankoop-dto";

export interface KassaHomeKlantDto {

  id: number;
  type: KlantType;
  naam: string;
  aankopen: AankoopDto[];


}
