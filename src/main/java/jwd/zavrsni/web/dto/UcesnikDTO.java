package jwd.zavrsni.web.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UcesnikDTO {
	private Long id;
	@NotBlank
	@Size(max=40)
	private String naziv;
	private String mesto;
	@Email
	private String kontakt;
	private Integer odigranoSusreta;
	private Integer brojBodova;
	
	private Long takmicenjeId;
	private String takmicenjeNaziv;
	//get i set
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
	public Long getTakmicenjeId() {
		return takmicenjeId;
	}
	public void setTakmicenjeId(Long takmicenjeId) {
		this.takmicenjeId = takmicenjeId;
	}
	public String getTakmicenjeNaziv() {
		return takmicenjeNaziv;
	}
	public void setTakmicenjeNaziv(String takmicenjeNaziv) {
		this.takmicenjeNaziv = takmicenjeNaziv;
	}
	
	
}
