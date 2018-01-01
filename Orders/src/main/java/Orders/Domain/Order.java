package Orders.Domain;

import Accounts.Domain.ValueObjects.UserId;
import shared.Money;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Order {

    private OrderId id;

    private LocalDate dateOfOrder;

    private Money price = new Money();

    private Set<UserId> users = new HashSet<>();

    private UserId owner;

    Order(UserId ownerId) {
        this.owner = ownerId;
        this.id = new OrderId();
    }

    public void addNewUser(UserId userId) {
        users.add(userId);
    }

    public Set<UserId> getUsers() {
        return users;
    }

    public OrderId getId() {
        return id;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public Money getPrice() {
        return price;
    }

    public UserId getOwner() {
        return owner;
    }

}
