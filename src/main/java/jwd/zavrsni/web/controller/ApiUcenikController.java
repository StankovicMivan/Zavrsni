package jwd.zavrsni.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.zavrsni.model.Ucesnik;
import jwd.zavrsni.service.UcesnikService;
import jwd.zavrsni.support.UcesnikDTOToUcesnik;
import jwd.zavrsni.support.UcesnikToUcesnikDTO;
import jwd.zavrsni.web.dto.UcesnikDTO;



@RestController
@RequestMapping("/api/ucesnici")
public class ApiUcenikController {
	@Autowired
	private UcesnikService ucesnikService;
	
	@Autowired
	private UcesnikToUcesnikDTO toDTO;
	@Autowired
	private UcesnikDTOToUcesnik toUcesnik;


	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UcesnikDTO>> get(
			@RequestParam(required = false) Long takmicenjeId,
			@RequestParam(required = false) String naziv,
			@RequestParam(defaultValue = "0") int pageNum) {

		Page<Ucesnik> ucesnici;

		if (takmicenjeId != null || naziv != null ) {
			ucesnici = ucesnikService.pretraga(takmicenjeId, naziv, pageNum);
		} else {
			ucesnici = ucesnikService.findAll(pageNum);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(ucesnici.getTotalPages()));
		return new ResponseEntity<>(toDTO.convert(ucesnici.getContent()), headers, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<UcesnikDTO> get(@PathVariable Long id) {
		Ucesnik ucesnik = ucesnikService.findOne(id);

		if (ucesnik == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(ucesnik), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<UcesnikDTO> add(
			@RequestBody UcesnikDTO noviUcesnik){
		
		Ucesnik ucesnik = toUcesnik.convert(noviUcesnik); 
		if(ucesnik.getTakmicenje().getFormat().getBrojUcesnika() < ucesnik.getTakmicenje().getFormat().getTakmicenja().size()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ucesnikService.save(ucesnik);
		
		return new ResponseEntity<>(toDTO.convert(ucesnik),
				HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,value="/{id}")
	public ResponseEntity<UcesnikDTO> edit(
			@PathVariable Long id,
			@RequestBody UcesnikDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Ucesnik ucesnik = toUcesnik.convert(izmenjen); 
		ucesnikService.save(ucesnik);
		
		return new ResponseEntity<>(toDTO.convert(ucesnik),
				HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public ResponseEntity<UcesnikDTO> delete(@PathVariable Long id){
		ucesnikService.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<Void> validationHandler(
					DataIntegrityViolationException e){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
