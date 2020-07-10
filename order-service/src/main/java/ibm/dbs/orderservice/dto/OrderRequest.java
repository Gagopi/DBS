package ibm.dbs.orderservice.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Component
public class OrderRequest {

	@NotEmpty
	private List<OrderItem> orderItems;
	private Date orderDate;
	@Length(min=3 ,max =20)
	private String customerName;
	@Length(max=100)
	private String shippingAddress;
	private double totalPrice;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "OrderRequest [orderItems=" + orderItems + ", orderDate=" + orderDate + ", customerName=" + customerName
				+ ", shippingAddress=" + shippingAddress + ", totalPrice=" + totalPrice + "]";
	}
       
}
