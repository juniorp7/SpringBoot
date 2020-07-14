package br.edu.univas.creso.servicos;

import java.util.Date;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.univas.creso.dao.AuditingDAO;
import br.edu.univas.creso.dao.OrderDAO;
import br.edu.univas.creso.entidades.Auditing;
import br.edu.univas.creso.entidades.Order;

@Service
public class OrderSevico {
	
	AuditingDAO auditingDao;
	OrderDAO orderDao;

	public ResponseEntity<Object> getOrderById(long id) {
		Optional<Order> order = orderDao.findById(id);
		if(order.isPresent()) {
			return ResponseEntity.ok(order);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Object> createOrder(Order order) {
		Order orderCriada = orderDao.save(order);
		Auditing log = new Auditing(Long.parseLong(java.util.UUID.randomUUID().toString()), orderCriada, "create", new Date());
		auditingDao.save(log);
		return ResponseEntity.ok(orderCriada);
	}

	public ResponseEntity<Object> updateOrder(Order order, long id) {
		Optional<Order> orderOld = orderDao.findById(id);
		
		if(!orderOld.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Order orderOld2 = orderOld.get();
		orderOld2.setAmount(order.getAmount());
		orderOld2.setCpf(order.getCpf());
		orderOld2.setValue(order.getValue());
		
		Order orderAtualizada = orderDao.save(orderOld2);
		
		Auditing log = new Auditing(Long.parseLong(java.util.UUID.randomUUID().toString()), orderOld2, "update", new Date());
		auditingDao.save(log);
		
		return ResponseEntity.ok(orderAtualizada);
	}

	public ResponseEntity<Object> deleteOrder(long id) {
		Optional<Order> order = orderDao.findById(id);
		if(order.isPresent()) {
			Auditing log = new Auditing(Long.parseLong(java.util.UUID.randomUUID().toString()), order.get(), "delete", new Date());
			auditingDao.save(log);
			orderDao.delete(order.get());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
