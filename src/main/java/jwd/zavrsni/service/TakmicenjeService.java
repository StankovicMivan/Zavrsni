package jwd.zavrsni.service;

import java.util.List;

import org.springframework.data.domain.Page;

import jwd.zavrsni.model.Takmicenje;



public interface TakmicenjeService {

	Page<Takmicenje> findAll(int pageNum);
	List<Takmicenje> findAll();
	Takmicenje findOne(Long id);
	Takmicenje save(Takmicenje takmicenje);
	void remove(Long id);
}
