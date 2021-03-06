package dao;

import file.ReadFile;
import file.WriteFile;
import model.User;
import validator.SighUpValidator;

import java.util.*;

/**
 * Created by dima on 18.3.17.
 */
public class UserDaoImpl implements UserDao {
    private ReadFile readFile = new ReadFile();
    private Map<String, String> hashmap = new HashMap<String, String>();

    @Override
    public List<User> getAll() {
        readFile.readItem("User.txt");
        return readFile.getUserList();
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean create() {
        User user = null;
        WriteFile writeFile = new WriteFile();
        Scanner in = new Scanner(System.in);
        SighUpValidator sighUpValidator = new SighUpValidator();
        try {
            do {
                System.out.println("Логин");//MI5465678
                hashmap.put("login", in.next());
                System.out.println("Пароль");
                hashmap.put("password", in.next());
                System.out.println("Паспорт");
                hashmap.put("passport", in.next());
                System.out.println("Роль");
                hashmap.put("role", in.next());
                user = new User(hashmap.get("login"), hashmap.get("password"), hashmap.get("passport"),hashmap.get("role"));
            } while (!sighUpValidator.validate(user));
        } catch (Exception e) {
            return false;
        } finally {
            writeFile.writeItem(user,"User.txt");
        }
        return true;
    }
}
