package org.colegio.web.repository;

import org.colegio.web.model.NotasBimestrales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasBimestralesRepository extends JpaRepository<NotasBimestrales, Long>{

}
