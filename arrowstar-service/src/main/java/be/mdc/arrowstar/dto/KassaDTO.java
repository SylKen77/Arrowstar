package be.mdc.arrowstar.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutableKassaDTO.class)
@JsonDeserialize(as = ImmutableKassaDTO.class)
public interface KassaDTO {

	double getSaldo();
	LocalDateTime getLaatstNageteldOp();
	LocalDateTime getLaatstAfgeslotenOp();

	List<VerrichtingDTO> getVerrichtingen();
}
