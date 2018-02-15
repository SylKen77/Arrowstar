package be.mdc.arrowstar.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.OptionalInt;

@Value.Immutable
@JsonSerialize(as = ImmutableProductDTO.class)
@JsonDeserialize(as = ImmutableProductDTO.class)
public interface ProductDTO {

	int getId();
	String getNaam();
	double getPrijsLid();
	double getPrijsGast();
	LocalDateTime getAangemaaktOp();
	boolean isZichtbaar();
	int getSortOrder();

}
