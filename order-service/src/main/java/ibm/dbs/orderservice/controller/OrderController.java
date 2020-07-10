package ibm.dbs.orderservice.controller;

import java.util.ArrayList;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ibm.dbs.orderservice.model.Order;
import ibm.dbs.orderservice.dto.OrderItem;
import ibm.dbs.orderservice.dto.OrderRequest;
import ibm.dbs.orderservice.dto.OrderResponse;
import ibm.dbs.orderservice.service.OrderService;
import ibm.dbs.orderservice.service.OrderServiceFeignProxy;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderServiceFeignProxy proxy;

	/**
	 * Retreive All Orders
	 * 
	 * @return
	 */
	@GetMapping(path = "/order")
	public List<OrderResponse> getAllOrders() {
		List<Order> orders = orderService.getAllOrders();
		List<OrderResponse> response= new ArrayList<OrderResponse>();
		orders.forEach(order -> {
			List<OrderItem> orderItem = proxy.getOrderItemsById(order.getOrderId());
			OrderResponse res = buildOrderResponse(order, orderItem);
			response.add(res);
		});
		return response;

	}

	/**
	 * Retreive Order Info by Order Id
	 * 
	 * @return
	 */
	@GetMapping(path = "/order/{id}")
	public OrderResponse getOrderById(@PathVariable Long id) {
		
		Order order= orderService.getOrderById(id);
		List<OrderItem> orderItems= proxy.getOrderItemsById(order.getOrderId());
		return buildOrderResponse(order, orderItems);
	}

	/*
	 * Validate Request Body and add new Order with proper request
	 * 
	 * @param orderRequest
	 * 
	 * @return
	 */
	@PostMapping(path = "/order")
	public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
		ResponseEntity<?> responseEntity = null;
		List<OrderItem> orderItems = orderRequest.getOrderItems();
		Order order = orderItems.isEmpty() ? null
				: orderService.addNewOrder(new Order(orderRequest.getCustomerName(), orderRequest.getOrderDate(),
						orderRequest.getShippingAddress(),  orderRequest.getTotalPrice()));
		try {
			if (null != order) {
				proxy.addOrderItems(order.getOrderId(), orderItems);
				OrderResponse resp=buildOrderResponse(order, orderItems);
				responseEntity = new ResponseEntity<OrderResponse>(resp, HttpStatus.CREATED);
			} else {
				responseEntity = new ResponseEntity<String>("Unable to add Order", HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("Exception while creating Order" + e.getMessage(),
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	
	/**
	 * Build Order Response 
	 * @param order
	 * @param orderItems
	 * @return
	 */
	private OrderResponse buildOrderResponse(Order order, List<OrderItem> orderItems) {
		OrderResponse res = new OrderResponse();
		res.setOrderId(order.getOrderId());
		res.setCustomerName(order.getCustomerName());
		res.setOrderDate(order.getOrderDate());
		res.setOrderItems(orderItems);
		res.setShippingAddress(order.getShippingAddress());
		res.setTotalPrice(order.getPrice());
		return res;
	}
}
