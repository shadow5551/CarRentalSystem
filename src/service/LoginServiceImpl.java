package service;

import dao.UserDaoImpl;
import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dima on 18.3.17.
 */
public class LoginServiceImpl implements LoginService{
    private Map<String, String> hashmap = new HashMap<String, String>();

    @Override
    public User getCurrentUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = null;
        Scanner in = new Scanner(System.in);
        System.out.println("Логин");//MI5465678
        hashmap.put("login", in.next());
        System.out.println("Пароль");
        hashmap.put("password", in.next());
        user = userDao.isPresentUser(hashmap.get("login"), hashmap.get("password"));
        return user;
    }
}
