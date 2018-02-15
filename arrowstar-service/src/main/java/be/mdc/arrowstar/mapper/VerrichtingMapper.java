package be.mdc.arrowstar.mapper;

import be.mdc.arrowstar.domain.Afrekening;
import be.mdc.arrowstar.domain.Afsluiting;
import be.mdc.arrowstar.domain.Telling;
import be.mdc.arrowstar.domain.Verrichting;
import be.mdc.arrowstar.dto.*;
import org.springframework.stereotype.Component;

@Component
public class VerrichtingMapper {

	public VerrichtingDTO toDto(Verrichting verrichting) {
		if (verrichting instanceof Afrekening) return toDto((Afrekening) verrichting);
		if (verrichting instanceof Afsluiting) return toDto((Afsluiting) verrichting);
		if (verrichting instanceof Telling) return toDto((Telling) verrichting);
		throw new RuntimeException("Onbekende verrichting");
	}

	public AfrekeningDTO toDto(Afrekening afrekening) {
		return ImmutableAfrekeningDTO.builder()
				.bedrag(afrekening.getBedrag())
				.uitgevoerdOp(afrekening.getUitgevoerdOp())
				.build();
	}

	public TellingDTO toDto(Telling telling) {
		return ImmutableTellingDTO.builder()
				.bedrag(telling.getBedrag())
				.build();
	}

	public AfsluitingDTO toDto(Afsluiting afsluiting) {
		return ImmutableAfsluitingDTO.builder()
				.bedrag(afsluiting.getBedrag())
				.uitgevoerdOp(afsluiting.getUitgevoerdOp())
				.build();
	}
}
