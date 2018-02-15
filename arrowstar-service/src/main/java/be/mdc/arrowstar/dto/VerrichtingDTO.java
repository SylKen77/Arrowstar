package be.mdc.arrowstar.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDateTime;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type")
@JsonSubTypes({
		@JsonSubTypes.Type(value = TellingDTO.class, name = "TELLING"),
		@JsonSubTypes.Type(value = AfrekeningDTO.class, name = "AFREKENING"),
		@JsonSubTypes.Type(value = AfsluitingDTO.class, name = "AFSLUITING")
})
public interface VerrichtingDTO {

	double getBedrag();

	LocalDateTime getUitgevoerdOp();

}
