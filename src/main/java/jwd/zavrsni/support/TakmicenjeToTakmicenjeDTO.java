package jwd.zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.zavrsni.model.Takmicenje;
import jwd.zavrsni.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeToTakmicenjeDTO implements Converter<Takmicenje, TakmicenjeDTO> {

	@Override
	public TakmicenjeDTO convert(Takmicenje takmicenje) {
		TakmicenjeDTO dto = new TakmicenjeDTO();
		dto.setFormatId(takmicenje.getFormat().getId());
		dto.setFormatNaziv(takmicenje.getFormat().getNaziv());
		dto.setId(takmicenje.getId());
		dto.setNaziv(takmicenje.getNaziv());
		return dto;
	}
	public List<TakmicenjeDTO> convert(List<Takmicenje> takmicenja){
		List<TakmicenjeDTO> retVal = new ArrayList<>();
		for(Takmicenje it: takmicenja) {
			retVal.add(convert(it));
		}
		return retVal;
	}

}
