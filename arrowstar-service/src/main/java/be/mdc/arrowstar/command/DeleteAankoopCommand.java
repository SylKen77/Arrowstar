package be.mdc.arrowstar.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableDeleteAankoopCommand.class)
@JsonDeserialize(as = ImmutableDeleteAankoopCommand.class)
public interface DeleteAankoopCommand {

	int getPersoonId();

	int getProductId();

}
