package be.mdc.arrowstar.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableUpdateProductCommand.class)
@JsonDeserialize(as = ImmutableUpdateProductCommand.class)
public interface UpdateProductCommand {

	int getId();
	String getNaam();
	double getPrijsLid();
	double getPrijsGast();
	boolean isZichtbaar();
	int getSortOrder();

}
