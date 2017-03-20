package service;

import dao.OrderDaoImpl;
import model.User;

import java.util.*;

/**
 * Created by dima on 17.3.17.
 */
public class UserServiceImpl implements UserService {
    private OrderDaoImpl orderDao = new OrderDaoImpl();

    @Override
    public void payForDamage() {

    }

    @Override
    public boolean bookingNewCar(User currentUser) {
        if (!orderDao.create(currentUser)){
            return false;
        }else return true;
    }

    @Override
    public void bookedCar() {

    }


}
