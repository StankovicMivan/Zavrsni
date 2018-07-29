package jwd.zavrsni.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table
public class Format {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	@Column
	private Integer brojUcesnika;
	@Column
	private Integer pobeda;
	@Column
	private Integer nereseno;
	@Column
	private Integer gubitak;
	@OneToMany(mappedBy="format")
	private List<Takmicenje> takmicenja = new ArrayList<>();

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

	public Integer getBrojUcesnika() {
		return brojUcesnika;
	}

	public void setBrojUcesnika(Integer brojUcesnika) {
		this.brojUcesnika = brojUcesnika;
	}

	public List<Takmicenje> getTakmicenja() {
		return takmicenja;
	}

	public void setTakmicenja(List<Takmicenje> takmicenja) {
		this.takmicenja = takmicenja;
	}

	public Integer getPobeda() {
		return pobeda;
	}

	public void setPobeda(Integer pobeda) {
		this.pobeda = pobeda;
	}

	public Integer getNereseno() {
		return nereseno;
	}

	public void setNereseno(Integer nereseno) {
		this.nereseno = nereseno;
	}

	public Integer getGubitak() {
		return gubitak;
	}

	public void setGubitak(Integer gubitak) {
		this.gubitak = gubitak;
	}
	
	
	
}
