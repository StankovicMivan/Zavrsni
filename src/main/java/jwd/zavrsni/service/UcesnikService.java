package jwd.zavrsni.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.zavrsni.model.Ucesnik;



public interface UcesnikService {


	Page<Ucesnik> findAll(int pageNum);
	Ucesnik findOne(Long id);
	void save(Ucesnik ucesnik);
	void remove(Long id);
	List<Ucesnik> findByTakmicenjeId(Long takmicenjeId);
	Page<Ucesnik> pretraga(
			@Param("takmicenjeId") Long takmicenjeId, 
			@Param("naziv") String naziv,
			int page);
}
