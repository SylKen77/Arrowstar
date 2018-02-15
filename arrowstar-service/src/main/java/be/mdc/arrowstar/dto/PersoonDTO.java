package be.mdc.arrowstar.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface PersoonDTO {

	OptionalInt getId();
	String getNaam();
	String getVoornaam();
	Optional<LocalDateTime> getAangemaaktOp();
	Optional<LocalDateTime> getVerwijderdOp();
	Optional<List<AankoopDTO>> getAankopen();

}
