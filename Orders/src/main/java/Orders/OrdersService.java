package Orders;

import Accounts.Domain.ValueObjects.UserId;
import Orders.Commands.AddUserToOrderCommand;
import Orders.Commands.MakeOrderCommand;
import Orders.Domain.Order;
import Orders.Domain.OrderBuilder;
import Orders.Domain.OrderId;
import Orders.Exceptions.OrderDoesntExistException;
import Orders.Ports.OrdersDAO;

public class OrdersService {

    private OrdersDAO ordersDAO;

    public OrdersService(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }

    public Order makeAnOrder(final MakeOrderCommand command){
        OrderBuilder builder = new OrderBuilder(command);
        Order order = builder.createEmptyOrderWithOwner();
        ordersDAO.save(order);
        return order;
    }

    public void addUserToOrder(final AddUserToOrderCommand command){
        UserId userId = command.getUserId();
        OrderId orderId = command.getOrderId();
        Order order = ordersDAO.findById(orderId).orElseThrow(OrderDoesntExistException::new);
        order.addNewUser(userId);
        ordersDAO.save(order);
    }
}
