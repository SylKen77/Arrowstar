package be.mdc.arrowstar.mapper;

import be.mdc.arrowstar.domain.Gast;
import be.mdc.arrowstar.dto.GastDTO;
import be.mdc.arrowstar.dto.ImmutableGastDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GastMapper {

	@Autowired private AankoopMapper aankoopMapper;

	public GastDTO toGastDto(Gast gast) {
		return ImmutableGastDTO.builder()
				.id(gast.getId())
				.naam(gast.getNaam())
				.voornaam(gast.getVoornaam())
				.aankopen(gast.getAankopen().stream().map(aankoopMapper::toAankoopDto).collect(Collectors.toList()))
				.aangemaaktOp(gast.getAangemaaktOp())
				.build();
	}

}
