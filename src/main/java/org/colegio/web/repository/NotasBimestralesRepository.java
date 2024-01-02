package org.colegio.web.repository;

import org.colegio.web.model.NotasBimestrales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasBimestralesRepository extends CrudRepository<NotasBimestrales, Long>{

}
