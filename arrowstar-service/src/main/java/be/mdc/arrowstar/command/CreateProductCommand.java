package be.mdc.arrowstar.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableCreateProductCommand.class)
@JsonDeserialize(as = ImmutableCreateProductCommand.class)
public interface CreateProductCommand {

	String getNaam();
	double getPrijsLid();
	double getPrijsGast();
	boolean isZichtbaar();
	int getSortOrder();

}
