package br.edu.univas.creso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.creso.entidades.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long>{

}
