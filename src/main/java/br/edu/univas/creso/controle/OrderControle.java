package br.edu.univas.creso.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.creso.entidades.Order;
import br.edu.univas.creso.servicos.OrderSevico;

@RestController
@RequestMapping("/order")
public class OrderControle {
	
	@Autowired
	OrderSevico service;
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Object> getOrderById(@PathVariable(value = "id") long id){
	        return service.getOrderById(id);
	    }

	    @PostMapping()
	    public ResponseEntity<Object> createOrder(@RequestBody Order order){
	        return service.createOrder(order);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Object> updateOrder(@PathVariable(value = "id") long id, @RequestBody Order order){
	        return service.updateOrder(order, id);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Object> deleteOrder(@PathVariable(value = "id") long id){
	        return service.deleteOrder(id);
	    }

}
