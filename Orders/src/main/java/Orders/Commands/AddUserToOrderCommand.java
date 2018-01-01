package Orders.Commands;

import Accounts.Domain.ValueObjects.UserId;
import Orders.Domain.OrderId;

public class AddUserToOrderCommand {
    private UserId userId;

    private OrderId orderId;

    public AddUserToOrderCommand(UserId userId, OrderId orderId) {
        this.userId = userId;
        this.orderId = orderId;
    }

    public UserId getUserId() {
        return userId;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
