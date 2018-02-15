package be.mdc.arrowstar.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableCreateAfsluitingCommand.class)
@JsonDeserialize(as = ImmutableCreateAfsluitingCommand.class)
public interface CreateAfsluitingCommand {

	double getHuidigSaldo();

}
