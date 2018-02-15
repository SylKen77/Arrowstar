package be.mdc.arrowstar.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableCreateGastCommand.class)
@JsonDeserialize(as = ImmutableCreateGastCommand.class)
public interface CreateGastCommand {

	String getNaam();

	String getVoornaam();

}
