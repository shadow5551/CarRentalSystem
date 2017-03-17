package service;

import model.User;

/**
 * Created by dima on 17.3.17.
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
