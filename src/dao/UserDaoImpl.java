package dao;

import file.ReadFile;
import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 18.3.17.
 */
public class UserDaoImpl implements UserDao {
    private List<User> userList = new ArrayList<>();
    private ReadFile readFile = new ReadFile();

    @Override
    public boolean isValidUser(User currentUser) {
        readFile.readItem("User.txt");
        userList = readFile.getUserList();
        for (User user : userList) {
            if (user.getLogin().equals(currentUser.getLogin())) {
                System.out.println("Такой логин уже присутствует в системе");
                return false;
            }
            if (user.getNumberOfPassport().equals(currentUser.getPassword())){
                System.out.println("Такой паспорт уже присутствует в системе");
                return false;
            }

        }
        return true;
    }

    @Override
    public User isPresentUser(String login, String password) {
        readFile.readItem("User.txt");
        userList = readFile.getUserList();
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
