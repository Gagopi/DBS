package ibm.dbs.orderservice.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="DBS_ORDER")
public class Order{
	
	public Order() {
		super();
	}
	public Order(String customerName, Date orderDate, String shippingAddress,
			double price) {
		super();
		
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.ShippingAddress = shippingAddress;
		this.price = price;
	}
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long order_id;
	@NotBlank(message="Customer Name is required")
	private String customerName;
	private Date orderDate;
	@Column(name="shippingaddress",length = 100,nullable = false)
	private String ShippingAddress;
	/*@Column(name="OrderItem")
  	private List<OrderItem> orderItems;
*/	private double price;
	public Long getOrderId() {
		return order_id;
	}
	public void setOrderId(Long orderId) {
		this.order_id = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getShippingAddress() {
		return ShippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		ShippingAddress = shippingAddress;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
