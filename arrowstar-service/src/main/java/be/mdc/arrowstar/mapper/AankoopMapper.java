package be.mdc.arrowstar.mapper;

import be.mdc.arrowstar.domain.Aankoop;
import be.mdc.arrowstar.dto.AankoopDTO;
import be.mdc.arrowstar.dto.ImmutableAankoopDTO;
import org.springframework.stereotype.Component;

@Component
public class AankoopMapper {

	public AankoopDTO toAankoopDto(Aankoop aankoop) {
		return ImmutableAankoopDTO.builder()
				.aangekochtOp(aankoop.getAangekochtOp())
				.prijs(aankoop.getPrijs())
				.productId(aankoop.getProductId())
				.productOmschrijving(aankoop.getProductNaam())
				.betaaldOp(aankoop.getBetaaldOp())
				.build();
	}
}
