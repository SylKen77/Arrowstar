package be.mdc.arrowstar.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Inheritance
@DiscriminatorColumn(name = "TYPE")
@Table(name = "PERSOON")
public abstract class Persoon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String naam;

	private String voornaam;

	private LocalDateTime aangemaaktOp;

	private LocalDateTime verwijderdOp;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Aankoop> aankopen;

	protected Persoon() {
	}

	public Persoon(String naam, String voornaam) {
		this.naam = naam;
		this.voornaam = voornaam;
		this.aangemaaktOp = LocalDateTime.now();
		this.aankopen = new ArrayList<>();
	}

	public abstract void afgerekend(Afrekening afrekening);

	protected abstract double getPrijs(Product product);

	public int getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public LocalDateTime getAangemaaktOp() {
		return aangemaaktOp;
	}

	public LocalDateTime getVerwijderdOp() {
		return verwijderdOp;
	}

	public void setVerwijderdOp(LocalDateTime verwijderdOp) {
		this.verwijderdOp = verwijderdOp;
	}

	public List<Aankoop> getAankopen() {
		return Collections.unmodifiableList(aankopen);
	}

	public List<Aankoop> getOnbetaaldeAankopen() {
		return Collections.unmodifiableList(aankopen.stream().filter(aankoop -> aankoop.getBetaaldOp() == null).collect(Collectors.toList()));
	}

	public void addAankoop(Product product) {
		aankopen.add(new Aankoop(product.getId(), product.getNaam(), getPrijs(product)));
	}

	public void verwijderAankoop(int productId) {
		aankopen.stream()
				.filter(aankoop -> aankoop.getBetaaldOp() == null)
				.filter(aankoop -> aankoop.getProductId() == productId)
				.findAny()
				.ifPresent(aankoop -> aankopen.remove(aankoop));
	}
}
