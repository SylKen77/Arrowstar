package be.mdc.arrowstar.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableTellingDTO.class)
@JsonDeserialize(as = ImmutableTellingDTO.class)
public interface TellingDTO extends VerrichtingDTO {

}
