package Orders.Domain;

import Accounts.Domain.ValueObjects.UserId;
import Orders.Commands.MakeOrderCommand;

public class OrderBuilder {

    private UserId ownerId;

    public OrderBuilder(MakeOrderCommand command) {
        ownerId = command.getOwnerId();
    }

    public Order createEmptyOrderWithOwner() {
        return new Order(ownerId);
    }
}
