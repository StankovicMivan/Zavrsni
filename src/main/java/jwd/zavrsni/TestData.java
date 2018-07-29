package jwd.zavrsni;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.zavrsni.model.Format;
import jwd.zavrsni.model.Takmicenje;
import jwd.zavrsni.model.Ucesnik;
import jwd.zavrsni.service.FormatService;
import jwd.zavrsni.service.TakmicenjeService;
import jwd.zavrsni.service.UcesnikService;


@Component
public class TestData {

	
	 @Autowired
	 private UcesnikService ucesnikService;
	
	 @Autowired
	 private TakmicenjeService takmicenjeService;
	
	 @Autowired
	 private FormatService formatService;


	@PostConstruct
	public void init() {

		Format f1 = new Format();
		f1.setBrojUcesnika(15);		
		f1.setNaziv("Fudbal");
		f1.setGubitak(0);
		f1.setNereseno(1);
		f1.setPobeda(3);
		formatService.save(f1);
		
		Takmicenje t1 = new Takmicenje();
		
		t1.setFormat(f1);
		t1.setNaziv("Super Liga");
		takmicenjeService.save(t1);
		
		Ucesnik u1 = new Ucesnik();
		u1.setBrojBodova(2);
		u1.setKontakt("ivan@gmail.com");
		u1.setMesto("Odzaci");
		u1.setNaziv("Tekstilac");
		u1.setOdigranoSusreta(10);
		u1.setTakmicenje(t1);
		
		ucesnikService.save(u1);
		takmicenjeService.save(t1);
		
	}
}
