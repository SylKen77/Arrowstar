package be.mdc.arrowstar.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String naam;

	private double prijsLid;

	private double prijsGast;

	private boolean zichtbaar;

	private LocalDateTime aangemaaktOp;

	private LocalDateTime verwijderdOp;

	private int sortOrder;

	@SuppressWarnings("unused")
	private Product() {
	}

	public Product(String naam, double prijsLid, double prijsGast, boolean zichtbaar, int sortOrder) {
		this.naam = naam;
		this.prijsLid = prijsLid;
		this.prijsGast = prijsGast;
		this.zichtbaar = zichtbaar;
		this.aangemaaktOp = LocalDateTime.now();
		this.sortOrder = sortOrder;
	}

	public LocalDateTime getAangemaaktOp() {
		return aangemaaktOp;
	}

	public int getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public double getPrijsGast() {
		return prijsGast;
	}

	public void setPrijsGast(double prijsGast) {
		this.prijsGast = prijsGast;
	}

	public double getPrijsLid() {
		return prijsLid;
	}

	public void setPrijsLid(double prijsLid) {
		this.prijsLid = prijsLid;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public void setVerwijderdOp(LocalDateTime verwijderdOp) {
		this.verwijderdOp = verwijderdOp;
	}

	public boolean isZichtbaar() {
		return zichtbaar && (verwijderdOp != null);
	}

	public void setZichtbaar(boolean zichtbaar) {
		this.zichtbaar = zichtbaar;
	}

}
