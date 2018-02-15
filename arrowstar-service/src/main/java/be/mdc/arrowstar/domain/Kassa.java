package be.mdc.arrowstar.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Kassa {

	@SuppressWarnings("unused")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double saldo;

	private LocalDateTime laatstNageteldOp;
	private LocalDateTime laatstAfgeslotenOp;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Verrichting> verrichtingen;

	@SuppressWarnings("unused")
	private Kassa() {
	}

	public Kassa(double beginSaldo) {
		this.saldo = beginSaldo;
		this.laatstAfgeslotenOp = LocalDateTime.now();
		this.laatstNageteldOp = LocalDateTime.now();
		this.verrichtingen = new ArrayList<>();
	}

	public void afrekenen(Afrekening afrekening) {
		this.saldo += afrekening.getBedrag();
		this.verrichtingen.add(afrekening);
	}

	public void afsluiten() {
		double bedrag = 150.00D - saldo;
		saldo = 150.00D;
		laatstAfgeslotenOp = LocalDateTime.now();
		verrichtingen.add(new Afsluiting(bedrag));
	}

	public LocalDateTime getLaatstAfgeslotenOp() {
		return laatstAfgeslotenOp;
	}

	public LocalDateTime getLaatstNageteldOp() {
		return laatstNageteldOp;
	}

	public double getSaldo() {
		return saldo;
	}

	public List<Verrichting> getVerrichtingen() {
		return Collections.unmodifiableList(verrichtingen);
	}

	public void tellen(double huidigSaldo) {
		double verschil = huidigSaldo - this.saldo;
		saldo = huidigSaldo;
		laatstNageteldOp = LocalDateTime.now();
		verrichtingen.add(new Telling(verschil));
	}

}
