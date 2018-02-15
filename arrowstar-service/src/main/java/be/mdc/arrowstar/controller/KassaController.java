package be.mdc.arrowstar.controller;

import be.mdc.arrowstar.command.*;
import be.mdc.arrowstar.dto.KassaDTO;
import be.mdc.arrowstar.dto.KlantDTO;
import be.mdc.arrowstar.dto.ProductDTO;
import be.mdc.arrowstar.service.KassaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/kassa")
public class KassaController {

	@Autowired private KassaService kassaService;

	@GetMapping
	public KassaDTO getKassa() {
		return kassaService.getKassaDTO();
	}

	@GetMapping("/klanten")
	public List<KlantDTO> getKlanten() {
		return kassaService.getKlanten().sorted(Comparator.comparing(KlantDTO::getType).thenComparing(KlantDTO::getNaam)).collect(Collectors.toList());
	}

	@GetMapping("/producten")
	public List<ProductDTO> getProducten() {
		return kassaService.getProducten().sorted(Comparator.comparing(ProductDTO::getSortOrder).thenComparing(ProductDTO::getNaam)).collect(Collectors.toList());
	}

	@PostMapping("/aankoop/create")
	@ResponseStatus(HttpStatus.OK)
	public void createAankoop(@RequestBody CreateAankoopCommand createAankoopCommand) {
		kassaService.createAankoop(createAankoopCommand);
	}

	@PostMapping("/aankoop/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAankoop(@RequestBody DeleteAankoopCommand deleteAankoopCommand) {
		kassaService.deleteAankoop(deleteAankoopCommand);
	}

	@PostMapping("/afrekenen")
	@ResponseStatus(HttpStatus.OK)
	public void afrekenen(@RequestBody CreateAfrekeningCommand createAfrekeningCommand) {
		kassaService.afrekenen(createAfrekeningCommand);
	}

	@PostMapping("/tellen")
	@ResponseStatus(HttpStatus.OK)
	public void tellen(@RequestBody CreateTellingCommand createTellingCommand) {
		kassaService.telling(createTellingCommand);
	}

	@PostMapping("/afsluiten")
	@ResponseStatus(HttpStatus.OK)
	public void afsluiten(@RequestBody CreateAfsluitingCommand createAfsluitingCommand) {
		kassaService.afsluiten(createAfsluitingCommand);
	}

}
