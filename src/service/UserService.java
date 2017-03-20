package service;

import model.User;

/**
 * Created by dima on 17.3.17.
 */
public interface UserService {
    void payForDamage();
    boolean bookingNewCar(User user);
    void bookedCar();
}
