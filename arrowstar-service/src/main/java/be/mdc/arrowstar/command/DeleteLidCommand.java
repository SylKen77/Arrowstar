package be.mdc.arrowstar.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableDeleteLidCommand.class)
@JsonDeserialize(as = ImmutableDeleteLidCommand.class)
public interface DeleteLidCommand {

	int getId();
}
