package br.edu.univas.creso.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.creso.entidades.Auditing;

@Repository
public interface AuditingDAO extends JpaRepository<Auditing, Long>{

}
