package dao;

import model.Car;
import model.User;

import java.util.List;

/**
 * Created by dima on 18.3.17.
 */
public interface UserDao {
    List<User> getAll();
    User update(User user);//при подключении к бд поменять на ключ сущности
    boolean delete(User user);
    boolean create();
}
