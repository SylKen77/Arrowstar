package be.mdc.arrowstar.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AFSLUITING")
public class Afsluiting extends Verrichting {

	public Afsluiting(double bedrag) {
		super(bedrag);
	}

}
