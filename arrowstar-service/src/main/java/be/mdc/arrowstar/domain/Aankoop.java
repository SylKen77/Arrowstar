package be.mdc.arrowstar.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Aankoop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int productId;

	private String productNaam;

	private double prijs;

	private LocalDateTime aangekochtOp;

	private LocalDateTime betaaldOp;


	@SuppressWarnings("unused")
	private Aankoop() {
	}

	public Aankoop(int productId, String productNaam, double prijs) {
		this.productId = productId;
		this.productNaam = productNaam;
		this.prijs = prijs;
		this.aangekochtOp = LocalDateTime.now();
	}

	public LocalDateTime getAangekochtOp() {
		return aangekochtOp;
	}

	public LocalDateTime getBetaaldOp() {
		return betaaldOp;
	}

	public void setBetaaldOp(LocalDateTime betaaldOp) {
		this.betaaldOp = betaaldOp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrijs() {
		return prijs;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductNaam() {
		return productNaam;
	}

}
