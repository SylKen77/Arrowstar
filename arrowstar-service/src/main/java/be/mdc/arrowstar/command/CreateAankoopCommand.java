package be.mdc.arrowstar.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableCreateAankoopCommand.class)
@JsonDeserialize(as = ImmutableCreateAankoopCommand.class)
public interface CreateAankoopCommand {

	int getPersoonId();

	int getProductId();

}
