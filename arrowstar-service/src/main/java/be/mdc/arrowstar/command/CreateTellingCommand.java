package be.mdc.arrowstar.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableCreateTellingCommand.class)
@JsonDeserialize(as = ImmutableCreateTellingCommand.class)
public interface CreateTellingCommand {

	double getBedrag();
}
