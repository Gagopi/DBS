package ibm.dbs.orderitemservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "Order_Item")
@Table(name = "Order_Item")
@IdClass(OrderItemId.class)

public class OrderItem {


	@Id
	private Long orderId;
	@Id
	private Long productCode;
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductCode() {
		return productCode;
	}

	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}

	private String productName;
	private int quantity;
	
	public OrderItem() {
		super();
	}

	public OrderItem(Long orderId, Long productCode, String productName, int quantity) {
		super();
		this.orderId = orderId;
		this.productCode = productCode;
		this.productName = productName;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
