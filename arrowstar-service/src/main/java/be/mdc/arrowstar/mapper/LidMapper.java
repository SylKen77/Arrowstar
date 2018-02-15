package be.mdc.arrowstar.mapper;

import be.mdc.arrowstar.domain.Lid;
import be.mdc.arrowstar.dto.ImmutableLidDTO;
import be.mdc.arrowstar.dto.LidDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LidMapper {

	@Autowired private AankoopMapper aankoopMapper;

	public LidDTO toLidDto(Lid lid) {
		return ImmutableLidDTO.builder()
				.id(lid.getId())
				.naam(lid.getNaam())
				.voornaam(lid.getVoornaam())
				.aangemaaktOp(lid.getAangemaaktOp())
				.verwijderdOp(lid.getVerwijderdOp())
				.isZichtbaarOpHomeScreen(lid.isZichtbaarOpHomeScreen())
				.aankopen(lid.getAankopen().stream().map(aankoopMapper::toAankoopDto).collect(Collectors.toList()))
				.build();
	}

}
