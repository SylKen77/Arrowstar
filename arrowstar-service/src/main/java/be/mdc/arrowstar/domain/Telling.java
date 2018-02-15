package be.mdc.arrowstar.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TELLING")
public class Telling extends Verrichting {

	public Telling(double bedrag) {
		super(bedrag);
	}
}
