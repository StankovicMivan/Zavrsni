package jwd.zavrsni.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.zavrsni.model.Ucesnik;
import jwd.zavrsni.service.TakmicenjeService;
import jwd.zavrsni.service.UcesnikService;
import jwd.zavrsni.web.dto.UcesnikDTO;

@Component
public class UcesnikDTOToUcesnik implements Converter<UcesnikDTO, Ucesnik>{

	@Autowired 
	private UcesnikService ucesnikService;
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Override
	public Ucesnik convert(UcesnikDTO dto) {
		Ucesnik ucesnik;
		if(dto.getId()==null) {
			ucesnik = new Ucesnik();
			ucesnik.setTakmicenje(takmicenjeService.findOne(dto.getTakmicenjeId())); 
		}else {
			ucesnik = ucesnikService.findOne(dto.getId());
			ucesnik.setBrojBodova(dto.getBrojBodova());
			ucesnik.setOdigranoSusreta(dto.getOdigranoSusreta());
			ucesnik.setTakmicenje(takmicenjeService.findOne(dto.getTakmicenjeId()));
		}
		ucesnik.setKontakt(dto.getKontakt());
		ucesnik.setMesto(dto.getMesto());
		ucesnik.setNaziv(dto.getNaziv());
		return ucesnik;
	}

}
