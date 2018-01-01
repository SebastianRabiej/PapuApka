package Orders.Ports;

import Orders.Domain.Order;
import Orders.Domain.OrderId;

import java.util.List;
import java.util.Optional;

public interface OrdersDAO {
    public Optional<Order> findById(OrderId id);

    public List<Order> findById(List<OrderId> id);

    public void save(Order order);

    int numberOfOrders();
}
