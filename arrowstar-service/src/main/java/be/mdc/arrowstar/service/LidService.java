package be.mdc.arrowstar.service;

import be.mdc.arrowstar.command.CreateLidCommand;
import be.mdc.arrowstar.command.DeleteLidCommand;
import be.mdc.arrowstar.command.UpdateLidCommand;
import be.mdc.arrowstar.domain.Lid;
import be.mdc.arrowstar.dto.LidDTO;
import be.mdc.arrowstar.mapper.LidMapper;
import be.mdc.arrowstar.repository.LidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Service
@Transactional
public class LidService {

	@Autowired private LidRepository lidRepository;
	@Autowired private LidMapper lidMapper;

	public Stream<LidDTO> getAlleLeden() {
		return lidRepository.streamAll().map(lidMapper::toLidDto);
	}

	public Stream<LidDTO> getActieveLeden() {
		return lidRepository.findAllByVerwijderdOpIsNull().map(lidMapper::toLidDto);
	}

	public Stream<LidDTO> getHomeScreenLeden() {
		return lidRepository.findAllByVerwijderdOpIsNullAndZichtbaarOpHomeScreenIsTrue().map(lidMapper::toLidDto);
	}

	public void createLid(CreateLidCommand createLidCommand) {
		Lid lid = new Lid(createLidCommand.getNaam(), createLidCommand.getVoornaam(), createLidCommand.isZichtbaarOpHomeScreen());
		lidRepository.save(lid);
	}

	public LidDTO getLid(int lidId) {
		return lidMapper.toLidDto(lidRepository.findOne(lidId));
	}

	public void updateLid(UpdateLidCommand updateLidCommand) {
		Lid bestaandLid = lidRepository.getOne(updateLidCommand.getId());
		bestaandLid.setNaam(updateLidCommand.getNaam());
		bestaandLid.setVoornaam(updateLidCommand.getVoornaam());
		bestaandLid.setZichtbaarOpHomeScreen(updateLidCommand.isZichtbaarOpHomeScreen());
	}

	public void deleteLid(DeleteLidCommand deleteLidCommand) {
		Lid bestaandLid = lidRepository.getOne(deleteLidCommand.getId());
		bestaandLid.setVerwijderdOp(LocalDateTime.now());
	}

}
