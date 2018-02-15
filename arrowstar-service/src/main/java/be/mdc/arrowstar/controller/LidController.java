package be.mdc.arrowstar.controller;

import be.mdc.arrowstar.command.CreateLidCommand;
import be.mdc.arrowstar.command.DeleteLidCommand;
import be.mdc.arrowstar.command.UpdateLidCommand;
import be.mdc.arrowstar.dto.LidDTO;
import be.mdc.arrowstar.service.LidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lid")
public class LidController {

	@Autowired private LidService lidService;

	@GetMapping("/homescreen")
	public List<LidDTO> getLedenVoorHomeScreen() {
		return lidService.getHomeScreenLeden().sorted(Comparator.comparing(LidDTO::getVoornaam).thenComparing(LidDTO::getNaam)).collect(Collectors.toList());
	}

	@GetMapping
	public List<LidDTO> getLeden(@RequestParam(name = "all", required = false, defaultValue = "false") boolean all) {
		return (all ? lidService.getAlleLeden() : lidService.getActieveLeden()).collect(Collectors.toList());
	}

	@GetMapping("/{lidId}")
	public LidDTO getLid(@PathVariable(name = "lidId") int lidId) {
		return lidService.getLid(lidId);
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void createLid(@RequestBody CreateLidCommand createLidCommand) {
		lidService.createLid(createLidCommand);
	}

	@PostMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public void updateLid(@RequestBody UpdateLidCommand updateLidCommand) {
		lidService.updateLid(updateLidCommand);
	}

	@PostMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deleteLid(@RequestBody DeleteLidCommand deleteLidCommand) {
		lidService.deleteLid(deleteLidCommand);
	}

}
