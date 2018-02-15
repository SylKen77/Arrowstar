package be.mdc.arrowstar.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutableAfrekeningDTO.class)
@JsonDeserialize(as = ImmutableAfrekeningDTO.class)
public interface AfrekeningDTO extends VerrichtingDTO {

	int getPersoonId();
	String getPersoonNaam();
	List<AankoopDTO> getAankopen();

}
