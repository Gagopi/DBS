package ibm.dbs.orderitemservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibm.dbs.orderitemservice.model.OrderItem;
import ibm.dbs.orderitemservice.model.OrderItemId;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId>{
		public List<OrderItem> findByOrderId(Long orderId);
}
