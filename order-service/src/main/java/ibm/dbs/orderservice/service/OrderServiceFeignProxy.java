package ibm.dbs.orderservice.service;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import ibm.dbs.orderservice.dto.OrderItem;

@FeignClient(name = "order-item-service", url = "http://localhost:8082")
public interface OrderServiceFeignProxy {

	@GetMapping( "/orderitems")
	public List<OrderItem> getAllOrderItems();

	@GetMapping("/orderitems/{orderId}/{productCode}")
	public OrderItem getOrderItemById(@PathVariable Long productCode, @PathVariable Long orderId);

	@PostMapping("/orderitems/{orderId}")
	public List<OrderItem> addOrderItems(@PathVariable Long orderId,@RequestBody List<OrderItem> orderItem);
	
	@GetMapping("/orderitems/{orderId}")
	public List<OrderItem> getOrderItemsById(@PathVariable Long orderId);
	

}
