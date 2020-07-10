package ibm.dbs.orderitemservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ibm.dbs.orderitemservice.model.OrderItem;
import ibm.dbs.orderitemservice.service.OrderItemService;

@RestController
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;
	


	@GetMapping("/orderitems/{orderId}")
	public List<OrderItem> getOrderItemsById(@PathVariable Long orderId){
		return orderItemService.getOrderItemsByOrderId(orderId);
	}
	
	/**
	 * add Order Item
	 * @param orderItem
	 */
	@PostMapping("/orderitems/{orderId}")
	public void addOrderItems(@PathVariable Long orderId,@RequestBody List<OrderItem> orderItems){
		orderItems.forEach(orderItem->{
			orderItem.setOrderId(orderId);
			orderItemService.addOrderItem(orderItem);
		});
	}
	
}
