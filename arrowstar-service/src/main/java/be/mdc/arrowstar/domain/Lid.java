package be.mdc.arrowstar.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LID")
public class Lid extends Persoon {

	private boolean zichtbaarOpHomeScreen;

	@SuppressWarnings("unused")
	private Lid() {
	}

	public Lid(String naam, String voornaam, boolean zichtbaarOpHomeScreen) {
		super(naam, voornaam);
		this.zichtbaarOpHomeScreen = zichtbaarOpHomeScreen;
	}

	@Override
	public void afgerekend(Afrekening afrekening) {
		// nothing
	}

	protected double getPrijs(Product product) {
		return product.getPrijsLid();
	}

	public boolean isZichtbaarOpHomeScreen() {
		return zichtbaarOpHomeScreen;
	}

	public void setZichtbaarOpHomeScreen(boolean zichtbaarOpHomeScreen) {
		this.zichtbaarOpHomeScreen = zichtbaarOpHomeScreen;
	}
}
