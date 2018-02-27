package be.mdc.arrowstar.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance
@DiscriminatorColumn(name = "TYPE")
@Table(name = "VERRICHTING")
public abstract class Verrichting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private double bedrag;

	private LocalDateTime uitgevoerdOp;


	@SuppressWarnings("unused")
	public Verrichting() {
	}

	public Verrichting(double bedrag) {
		this.bedrag = bedrag;
		this.uitgevoerdOp = LocalDateTime.now();
	}

	public long getId() {
		return id;
	}

	public double getBedrag() {
		return bedrag;
	}

	public LocalDateTime getUitgevoerdOp() {
		return uitgevoerdOp;
	}
}
