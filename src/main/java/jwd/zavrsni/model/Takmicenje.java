package jwd.zavrsni.model;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table
public class Takmicenje {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	
	@OneToMany(mappedBy="takmicenje")
	private List<Ucesnik> ucesnici = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Format format;

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

	public List<Ucesnik> getUcesnici() {
		return ucesnici;
	}

	public void setUcesnici(List<Ucesnik> ucesnici) {
		this.ucesnici = ucesnici;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
		if(format!=null && !format.getTakmicenja().contains(this)) {
			format.getTakmicenja().add(this);
		}
	}
	
	

	
	
	//ADD LINIJA
	
	
//	public void addLinija(Linija linija){
//		this.linije.add(linija);
//		
//		if(linija.getPrevoznik()!=this){
//			linija.setPrevoznik(this);
//		}
//	}
	
	//REMOVE LINIJA
	
//	public void removeLinija(Linija linija){
//		linija.setPrevoznik(null);
//		linije.remove(linija);
//	}
	
	
}
