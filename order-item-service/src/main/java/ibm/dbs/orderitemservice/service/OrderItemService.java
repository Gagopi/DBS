package ibm.dbs.orderitemservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibm.dbs.orderitemservice.exception.OrderItemNotFoundException;
import ibm.dbs.orderitemservice.model.OrderItem;
import ibm.dbs.orderitemservice.model.OrderItemId;
import ibm.dbs.orderitemservice.repository.OrderItemRepository;

@Service
public class OrderItemService {
	
	@Autowired
	OrderItemRepository orderItemRepo;
	
	public List<OrderItem> getAllOrderItems(){
		return orderItemRepo.findAll();
	}

	public OrderItem getOrderItemsById(OrderItemId orderItemId) {
		return orderItemRepo.findById(orderItemId).orElseThrow(() -> new OrderItemNotFoundException());
	}

	public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
		return orderItemRepo.findByOrderId(orderId);
	}
	
	public OrderItem addOrderItem(OrderItem orderItem) {
		return orderItemRepo.save(orderItem);
	}

}
