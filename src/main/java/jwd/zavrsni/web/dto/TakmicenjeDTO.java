package jwd.zavrsni.web.dto;

public class TakmicenjeDTO {

	private Long id;
	private String naziv;
	private Long formatId;
	private String formatNaziv;
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
	public Long getFormatId() {
		return formatId;
	}
	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}
	public String getFormatNaziv() {
		return formatNaziv;
	}
	public void setFormatNaziv(String formatNaziv) {
		this.formatNaziv = formatNaziv;
	}
	
	//get i set
	
}
