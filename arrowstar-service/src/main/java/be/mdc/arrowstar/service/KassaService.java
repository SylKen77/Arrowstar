package be.mdc.arrowstar.service;

import be.mdc.arrowstar.command.*;
import be.mdc.arrowstar.domain.*;
import be.mdc.arrowstar.dto.KassaDTO;
import be.mdc.arrowstar.dto.KlantDTO;
import be.mdc.arrowstar.dto.ProductDTO;
import be.mdc.arrowstar.mapper.KassaMapper;
import be.mdc.arrowstar.mapper.KlantMapper;
import be.mdc.arrowstar.mapper.ProductMapper;
import be.mdc.arrowstar.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class KassaService {

	@Autowired private PersoonRepository persoonRepository;
	@Autowired private LidRepository lidRepository;
	@Autowired private GastRepository gastRepository;
	@Autowired private ProductRepository productRepository;
	@Autowired private KassaRepository kassaRepository;

	@Autowired private KlantMapper klantMapper;
	@Autowired private ProductMapper productMapper;
	@Autowired private KassaMapper kassaMapper;

	public KassaDTO getKassaDTO() {
		return kassaMapper.kassaToKassaDto(getKassa());
	}

	public Stream<KlantDTO> getKlanten() {
		List<KlantDTO> klanten = lidRepository.findAllByVerwijderdOpIsNullAndZichtbaarOpHomeScreenIsTrue().map(klantMapper::lidToKlantDto).collect(Collectors.toList());
		klanten.addAll(gastRepository.findAllByAfgerekendIsFalse().map(klantMapper::gastToKlantDto).collect(Collectors.toList()));
		return klanten.stream();
	}

	public Stream<ProductDTO> getProducten() {
		return productRepository.findByZichtbaarIsTrueAndVerwijderdOpIsNull().map(productMapper::productToProductDto);
	}

	public void createAankoop(CreateAankoopCommand createAankoopCommand) {
		Persoon persoon = persoonRepository.findOne(createAankoopCommand.getPersoonId());
		Product product = productRepository.findOne(createAankoopCommand.getProductId());
		persoon.addAankoop(product);
	}

	public void deleteAankoop(DeleteAankoopCommand deleteAankoopCommand) {
		Persoon persoon = persoonRepository.findOne(deleteAankoopCommand.getPersoonId());
		persoon.verwijderAankoop(deleteAankoopCommand.getProductId());
	}

	public void afrekenen(CreateAfrekeningCommand createAfrekeningCommand) {
		Persoon persoon = persoonRepository.findOne(createAfrekeningCommand.getPersoonId());
		Afrekening afrekening = new Afrekening(persoon.getId(), persoon.getOnbetaaldeAankopen());
		getKassa().afrekenen(afrekening);
		persoon.afgerekend(afrekening);
	}

	public void telling(CreateTellingCommand createTellingCommand) {
		getKassa().tellen(createTellingCommand.getBedrag());
	}

	public void afsluiten(CreateAfsluitingCommand createAfsluitingCommand) {
		Kassa kassa = getKassa();
		kassa.tellen(createAfsluitingCommand.getHuidigSaldo());
		kassa.afsluiten();
	}

	private Kassa getKassa() {
		List<Kassa> kassaList = kassaRepository.findAll();
		if (kassaList.isEmpty()) {
			Kassa kassa = new Kassa(150.00D);
			return kassaRepository.save(kassa);
		}
		return kassaList.get(0);
	}

}
