package be.mdc.arrowstar.mapper;

import be.mdc.arrowstar.domain.Kassa;
import be.mdc.arrowstar.dto.ImmutableKassaDTO;
import be.mdc.arrowstar.dto.KassaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class KassaMapper {

	@Autowired private VerrichtingMapper verrichtingMapper;

	public KassaDTO kassaToKassaDto(Kassa kassa) {
		return ImmutableKassaDTO.builder()
				.saldo(kassa.getSaldo())
				.laatstNageteldOp(kassa.getLaatstNageteldOp())
				.laatstAfgeslotenOp(kassa.getLaatstAfgeslotenOp())
				.verrichtingen(kassa.getVerrichtingen().stream().map(verrichtingMapper::toDto).collect(Collectors.toList()))
				.build();
	}

}
