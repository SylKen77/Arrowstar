package be.mdc.arrowstar.controller;

import be.mdc.arrowstar.command.CreateGastCommand;
import be.mdc.arrowstar.dto.GastDTO;
import be.mdc.arrowstar.service.GastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gast")
public class GastController {

	@Autowired private GastService gastService;

	@GetMapping
	public List<GastDTO> getGasten(@RequestParam(name = "all", required = false, defaultValue = "false") boolean all) {
		return (all ? gastService.getAlleGasten() : gastService.getActieveGasten()).collect(Collectors.toList());
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void createGast(@RequestBody CreateGastCommand createGastCommand) {
		gastService.createGast(createGastCommand);
	}

}
