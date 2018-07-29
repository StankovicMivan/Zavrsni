package jwd.zavrsni.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.zavrsni.model.Takmicenje;
import jwd.zavrsni.model.Ucesnik;
import jwd.zavrsni.service.TakmicenjeService;
import jwd.zavrsni.service.UcesnikService;
import jwd.zavrsni.support.TakmicenjeToTakmicenjeDTO;
import jwd.zavrsni.support.UcesnikToUcesnikDTO;
import jwd.zavrsni.web.dto.TakmicenjeDTO;
import jwd.zavrsni.web.dto.UcesnikDTO;



@RestController
@RequestMapping("/api/takmicenja")
public class ApiTakmicenjeController {

	@Autowired
	private TakmicenjeService takmicenjeService;
	@Autowired
	private TakmicenjeToTakmicenjeDTO toDTO;
	@Autowired
	private UcesnikService ucesnikService;	
	@Autowired
	private UcesnikToUcesnikDTO toUcesnikDTO;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TakmicenjeDTO>> get() {

		List<Takmicenje> takmicenja;
	
		takmicenja = takmicenjeService.findAll();	

		return new ResponseEntity<>(toDTO.convert(takmicenja), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value="/{id}/ucesnici")
	ResponseEntity<List<UcesnikDTO>> getAll(@PathVariable Long id){
		
		List<Ucesnik> ucesnici = ucesnikService.findByTakmicenjeId(id);
		return new ResponseEntity<>(toUcesnikDTO.convert(ucesnici), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<List<UcesnikDTO>> get(
			@RequestParam(required = false) Long idPrvog,
			@RequestParam(required = false) Long idDrugog,
			@RequestParam(required = false) int zvanicno,
			@RequestParam(defaultValue = "0") int pageNum) {

	System.out.println(idPrvog);
	System.out.println(idDrugog);
	System.out.println(zvanicno);	

		return new ResponseEntity<>(  HttpStatus.OK);
	}
	
}
