package dao;

import model.Order;
import model.User;

import java.util.List;

/**
 * Created by dima on 20.3.17.
 */
public interface OrderDao {
    List<Order> getAll();
    boolean create(User currentUser);
    Order update(Order order);
}
