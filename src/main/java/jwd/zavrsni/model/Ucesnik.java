package jwd.zavrsni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table
public class Ucesnik {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(nullable= false, unique=true)
	private String naziv;
	@Column
	private String mesto;
	@Column(nullable=false)
	private String kontakt;
	@Column
	private Integer odigranoSusreta =0;
	@Column
	private Integer brojBodova =0;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Takmicenje takmicenje;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public Integer getOdigranoSusreta() {
		return odigranoSusreta;
	}

	public void setOdigranoSusreta(Integer odigranoSusreta) {
		this.odigranoSusreta = odigranoSusreta;
	}

	public Integer getBrojBodova() {
		return brojBodova;
	}

	public void setBrojBodova(Integer brojBodova) {
		this.brojBodova = brojBodova;
	}

	public Takmicenje getTakmicenje() {
		return takmicenje;
	}

	public void setTakmicenje(Takmicenje takmicenje) {
		this.takmicenje = takmicenje;
		if(takmicenje!=null && !takmicenje.getUcesnici().contains(this)) {
			takmicenje.getUcesnici().add(this);
		}
	}


	
	

}
