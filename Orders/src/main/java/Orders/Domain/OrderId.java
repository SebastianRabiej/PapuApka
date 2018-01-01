package Orders.Domain;

import java.util.UUID;

public class OrderId {

    private UUID value;

    public OrderId(){
        this.value = UUID.randomUUID();
    }
}
