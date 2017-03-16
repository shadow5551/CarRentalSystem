package interfaces;


import registration.User;

import java.util.List;

/**
 * Created by dima on 15.3.17.
 */
public interface Reader {
    List<User> readUsers(String nameOfFile) throws Exception;
}
