package validator;

import dao.UserDaoImpl;
import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 19.3.17.
 */
public class SignInValidator {

    public User isExistingUser(String login, String password) {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> userList = userDao.getAll();
        for (User user : userList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)){
                System.out.println("C возвращением, " + login);
                return user;
            }
            if (!user.getPassword().equals(password) && user.getLogin().equals(login)){
                System.out.println("Неверно введен пароль");
                return null;
            }

        }
        System.out.println("Пользователь не найден");
        return null;
    }
}
