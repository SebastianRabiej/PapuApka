package Orders.Adapters;

import Orders.Domain.Order;
import Orders.Domain.OrderId;
import Orders.Ports.OrdersDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryOrderDao implements OrdersDAO{

    List<Order> inMemoryDatabase = new ArrayList();

    @Override
    public Optional<Order> findById(OrderId id) {
        return inMemoryDatabase.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Order> findById(List<OrderId> id) {
        return inMemoryDatabase.stream()
                .filter(order -> order.getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Order order) {
        inMemoryDatabase.add(order);
    }

    @Override
    public int numberOfOrders() {
        return inMemoryDatabase.size();
    }
}
