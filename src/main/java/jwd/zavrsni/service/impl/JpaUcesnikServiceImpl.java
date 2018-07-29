package jwd.zavrsni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import jwd.zavrsni.model.Ucesnik;
import jwd.zavrsni.repository.UcesnikRepository;
import jwd.zavrsni.service.UcesnikService;



@Service
public class JpaUcesnikServiceImpl implements UcesnikService{
	
	@Autowired
	private UcesnikRepository ucesnikRepository;
	
	@Override
	public Page<Ucesnik> findAll(int pageNum) {
		
		return ucesnikRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Ucesnik findOne(Long id) {
		
		return ucesnikRepository.findOne(id);
	}

	@Override
	public void save(Ucesnik ucesnik) {
	
		ucesnikRepository.save(ucesnik);
	}

	@Override
	public void remove(Long id) {
	
		ucesnikRepository.delete(id);
		
	}

	@Override
	public List<Ucesnik> findByTakmicenjeId( Long takmicenjeId) {
		return ucesnikRepository.findByTakmicenjeId(takmicenjeId);
	}
	@Override
	public Page<Ucesnik> pretraga(Long takmicenjeId, String naziv, int page) {
		if(naziv != null) {
			naziv = "%" + naziv + "%";
		}
		return ucesnikRepository.pretraga(takmicenjeId, naziv, new PageRequest(page, 5));
	}

	

	

	
}
