package be.mdc.arrowstar.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableAankoopCommand.class)
@JsonDeserialize(as = ImmutableAankoopCommand.class)
public interface AankoopCommand {

    int getPersoonId();

    int getProductId();

    AankoopCommandType getType();
}
