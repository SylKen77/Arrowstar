package be.mdc.arrowstar.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableGastDTO.class)
@JsonDeserialize(as = ImmutableGastDTO.class)
public interface GastDTO extends PersoonDTO {

}
