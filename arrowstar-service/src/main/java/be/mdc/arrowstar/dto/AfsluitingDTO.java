package be.mdc.arrowstar.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableAfsluitingDTO.class)
@JsonDeserialize(as = ImmutableAfsluitingDTO.class)
public interface AfsluitingDTO extends VerrichtingDTO {

}
