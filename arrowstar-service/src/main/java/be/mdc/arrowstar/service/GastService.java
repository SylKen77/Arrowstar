package be.mdc.arrowstar.service;

import be.mdc.arrowstar.command.CreateGastCommand;
import be.mdc.arrowstar.domain.Gast;
import be.mdc.arrowstar.dto.GastDTO;
import be.mdc.arrowstar.mapper.GastMapper;
import be.mdc.arrowstar.repository.GastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
@Transactional
public class GastService {

	@Autowired private GastRepository gastRepository;
	@Autowired private GastMapper gastMapper;

	public void createGast(CreateGastCommand createGastCommand) {
		gastRepository.save(new Gast(createGastCommand.getNaam(), createGastCommand.getVoornaam()));
	}

	public Stream<GastDTO> getActieveGasten() {
		return gastRepository.findAllByAfgerekendIsFalse().map(gastMapper::toGastDto);
	}

	public Stream<GastDTO> getAlleGasten() {
		return gastRepository.streamAll().map(gastMapper::toGastDto);
	}

}
