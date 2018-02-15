package be.mdc.arrowstar.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableUpdateLidCommand.class)
@JsonDeserialize(as = ImmutableUpdateLidCommand.class)
public interface UpdateLidCommand {

	int getId();
	String getNaam();
	String getVoornaam();
	boolean isZichtbaarOpHomeScreen();
}
