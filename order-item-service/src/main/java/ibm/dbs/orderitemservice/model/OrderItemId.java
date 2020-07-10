package ibm.dbs.orderitemservice.model;

import java.io.Serializable;

public class OrderItemId implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long orderId;
	private Long productCode;
	
	public OrderItemId() {
		super();
	}
	public OrderItemId(Long orderId, Long productCode) {
		super();
		this.orderId = orderId;
		this.productCode = productCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemId other = (OrderItemId) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		return true;
	}
	
}
