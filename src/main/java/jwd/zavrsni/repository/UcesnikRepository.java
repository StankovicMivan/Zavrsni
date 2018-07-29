package jwd.zavrsni.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.zavrsni.model.Ucesnik;





@Repository
public interface UcesnikRepository  extends JpaRepository<Ucesnik, Long>{

	List<Ucesnik> findByTakmicenjeId(Long takmicenjeId);
	
	@Query("SELECT u FROM Ucesnik u WHERE "
			+ "(:takmicenjeId IS NULL or u.takmicenje.id = :takmicenjeId ) AND "
			+ "(:naziv IS NULL OR u.naziv like :naziv  )"
			)
	Page<Ucesnik> pretraga(
			@Param("takmicenjeId") Long takmicenjeId, 
			@Param("naziv") String naziv, Pageable pageRequest);

 
}
