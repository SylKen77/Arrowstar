package be.mdc.arrowstar.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableCreateLidCommand.class)
@JsonDeserialize(as = ImmutableCreateLidCommand.class)
public interface CreateLidCommand {

	String getNaam();
	String getVoornaam();
	boolean isZichtbaarOpHomeScreen();

}
