package be.mdc.arrowstar.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.internal.Nullable;
import org.immutables.value.Value;

import java.time.LocalDateTime;
import java.util.Optional;

@Value.Immutable
@JsonSerialize(as = ImmutableAankoopDTO.class)
@JsonDeserialize(as = ImmutableAankoopDTO.class)
public interface AankoopDTO {

	int getProductId();
	String getProductOmschrijving();
	double getPrijs();
	LocalDateTime getAangekochtOp();
	@Nullable LocalDateTime getBetaaldOp();

}
