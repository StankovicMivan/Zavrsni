package jwd.zavrsni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.zavrsni.model.Format;
import jwd.zavrsni.repository.FormatRepository;
import jwd.zavrsni.service.FormatService;

@Service
public class JpaFormatServiceImpl implements FormatService {
	
	@Autowired
	FormatRepository repository;

	public List<Format> findAll() {
	
		return repository.findAll();
	}


	public Format findOne(Long id) {
		
		return repository.findOne(id);
	}

	
	public Format save(Format pozicija) {
	
		return repository.save(pozicija);
	}

	
	public void remove(Long id) {
		
		repository.delete(id);
	}

}
