package be.mdc.arrowstar.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableCreateAfrekeningCommand.class)
@JsonDeserialize(as = ImmutableCreateAfrekeningCommand.class)
public interface CreateAfrekeningCommand {

	int getPersoonId();

}
