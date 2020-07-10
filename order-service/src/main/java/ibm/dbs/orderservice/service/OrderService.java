package ibm.dbs.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibm.dbs.orderservice.exception.OrderNotFoundException;
import ibm.dbs.orderservice.model.Order;
import ibm.dbs.orderservice.repository.OrderRepository;

@Service
public class OrderService{
	
	@Autowired
	OrderRepository orderRepo;
	
	public List<Order> getAllOrders(){
		return orderRepo.findAll() ;
	}
	
	public Order getOrderById(Long orderId) {
		return orderRepo.findById(orderId).orElseThrow(() -> new OrderNotFoundException());
	}

	public Order addNewOrder(Order order) {
		return orderRepo.save(order);
	}

}
