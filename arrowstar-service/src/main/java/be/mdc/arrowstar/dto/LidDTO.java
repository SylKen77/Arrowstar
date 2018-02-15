package be.mdc.arrowstar.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonSerialize(as = ImmutableLidDTO.class)
@JsonDeserialize(as = ImmutableLidDTO.class)
public interface LidDTO extends PersoonDTO {

	Optional<Boolean> isZichtbaarOpHomeScreen();

}
