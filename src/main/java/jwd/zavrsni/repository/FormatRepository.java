package jwd.zavrsni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import jwd.zavrsni.model.Format;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {

}
