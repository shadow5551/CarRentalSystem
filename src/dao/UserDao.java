package dao;

import model.User;

/**
 * Created by dima on 18.3.17.
 */
public interface UserDao {
    boolean isValidUser(User user);
    User isPresentUser(String login,String password);
}
