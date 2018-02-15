package be.mdc.arrowstar.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutableKlantDTO.class)
@JsonDeserialize(as = ImmutableKlantDTO.class)
public interface KlantDTO {

	int getPersoonId();
	KlantType getType();
	String getNaam();

	double getSaldo();
	List<AankoopDTO> getAankopen();

}
