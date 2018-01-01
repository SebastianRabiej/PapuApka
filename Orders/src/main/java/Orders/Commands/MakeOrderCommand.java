package Orders.Commands;

import Accounts.Domain.ValueObjects.UserId;
import Orders.Domain.OrderId;

public class MakeOrderCommand {
    private UserId ownerId;

    public MakeOrderCommand(UserId ownerId) {
        this.ownerId = ownerId;
    }

    public UserId getOwnerId() {
        return ownerId;
    }
}
