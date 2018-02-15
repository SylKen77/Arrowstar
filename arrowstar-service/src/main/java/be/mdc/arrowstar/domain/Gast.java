package be.mdc.arrowstar.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GAST")
public class Gast extends Persoon {

	private boolean afgerekend;

	@SuppressWarnings("unused")
	private Gast() {
	}

	public Gast(String naam, String voornaam) {
		super(naam, voornaam);
	}

	@Override
	public void afgerekend(Afrekening afrekening) {
		this.afgerekend = true;
	}

	protected double getPrijs(Product product) {
		return product.getPrijsGast();
	}

	public boolean isAfgerekend() {
		return this.afgerekend;
	}

}
