package jwd.zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.zavrsni.model.Ucesnik;
import jwd.zavrsni.web.dto.UcesnikDTO;

@Component
public class UcesnikToUcesnikDTO implements Converter<Ucesnik, UcesnikDTO>{

	@Override
	public UcesnikDTO convert(Ucesnik ucesnik) {
		UcesnikDTO dto = new UcesnikDTO();
		
		dto.setBrojBodova(ucesnik.getBrojBodova());
		dto.setId(ucesnik.getId());
		dto.setKontakt(ucesnik.getKontakt());
		dto.setMesto(ucesnik.getMesto());
		dto.setNaziv(ucesnik.getNaziv());
		dto.setOdigranoSusreta(ucesnik.getOdigranoSusreta());
		dto.setTakmicenjeId(ucesnik.getTakmicenje().getId());
		dto.setTakmicenjeNaziv(ucesnik.getTakmicenje().getNaziv());
		
		return dto;
	}
	public List<UcesnikDTO> convert(List<Ucesnik> ucesnici){
		List<UcesnikDTO> retVal = new ArrayList<>();
		
		for(Ucesnik it: ucesnici) {
			retVal.add(convert(it));
		}
		return retVal;
	}

}
