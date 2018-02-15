package be.mdc.arrowstar.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.time.LocalDateTime;

@Value.Immutable
@JsonSerialize(as = ImmutableAankoopDTO.class)
@JsonDeserialize(as = ImmutableAankoopDTO.class)
public interface AankoopDTO {

	int getProductId();
	String getProductOmschrijving();
	double getPrijs();
	LocalDateTime getAangekochtOp();
	LocalDateTime getBetaaldOp();

}
