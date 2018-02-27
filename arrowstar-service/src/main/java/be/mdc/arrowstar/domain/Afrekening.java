package be.mdc.arrowstar.domain;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@DiscriminatorValue("AFREKENING")
public class Afrekening extends Verrichting {

	private int persoonId;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Aankoop> aankopen;

	public Afrekening() {
	}

	public Afrekening(int persoonId, List<Aankoop> aankopen) {
		super(aankopen.stream().mapToDouble(aankoop -> aankoop.getPrijs()).sum());
		this.persoonId = persoonId;
		this.aankopen = aankopen;
		aankopen.forEach(aankoop -> aankoop.setBetaaldOp(LocalDateTime.now()));
	}

	public int getPersoonId() {
		return persoonId;
	}

	public List<Aankoop> getAankopen() {
		return aankopen;
	}

}
