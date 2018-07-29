package jwd.zavrsni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.zavrsni.model.Takmicenje;
import jwd.zavrsni.repository.TakmicenjeRepository;
import jwd.zavrsni.service.TakmicenjeService;



@Service
public class JpaTakmicenjeServiceImpl implements TakmicenjeService{

    @Autowired
	private TakmicenjeRepository takmicenjeRepository;
	
	@Override
	public List<Takmicenje> findAll() {
		
		return takmicenjeRepository.findAll();
	}

	@Override
	public Takmicenje findOne(Long id) {
		
		return takmicenjeRepository.findOne(id);
	}

	@Override
	public Takmicenje save(Takmicenje takmicenje) {
	
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public void remove(Long id) {
		takmicenjeRepository.delete(id);
		
	}

	@Override
	public Page<Takmicenje> findAll(int pageNum) {
		
		return takmicenjeRepository.findAll(new PageRequest(pageNum, 5));
	}

}
