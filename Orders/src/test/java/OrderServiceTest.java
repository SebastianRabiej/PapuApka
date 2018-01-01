import Accounts.Domain.ValueObjects.UserId;
import Orders.Adapters.InMemoryOrderDao;
import Orders.Commands.AddUserToOrderCommand;
import Orders.Commands.MakeOrderCommand;
import Orders.Domain.Order;
import Orders.OrdersService;
import Orders.Ports.OrdersDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {
    final private long ANY_ID = 2L;

    private OrdersDAO orderDao;

    private OrdersService ordersService;

    @BeforeEach
    void prepareService(){
        this.orderDao=new InMemoryOrderDao();
        this.ordersService = new OrdersService(orderDao);
    }

    @Test
    void created_order_should_not_be_null(){
        //given
        MakeOrderCommand command = new MakeOrderCommand(new UserId(ANY_ID));

        //when
        Order result = ordersService.makeAnOrder(command);

        //then
        assertThat(result).isNotNull();
    }

    @Test
    void created_order_should_have_ownerId(){
        //given
        UserId ownerId = new UserId(ANY_ID);
        MakeOrderCommand command = new MakeOrderCommand(ownerId);

        //when
        Order result = ordersService.makeAnOrder(command);

        //then
        assertThat(result.getOwner()).isNotNull();
        assertThat(result.getOwner()).isEqualTo(ownerId);
    }

    @Test
    void created_order_should_exist_in_database(){
        //given
        MakeOrderCommand command = new MakeOrderCommand(new UserId(ANY_ID));

        //when
        ordersService.makeAnOrder(command);

        //then
        assertThat(orderDao.numberOfOrders()).isEqualTo(1);
    }

    @Test
    void should_add_user_to_order(){
        //given
        UserId ownerId = new UserId(ANY_ID);
        MakeOrderCommand command = new MakeOrderCommand(ownerId);
        Order order = ordersService.makeAnOrder(command);

        //when
        ordersService.addUserToOrder(new AddUserToOrderCommand(ownerId,order.getId()));
        Set<UserId> users = order.getUsers();

        //then
        assertThat(users.size()).isEqualTo(1);
    }

}
