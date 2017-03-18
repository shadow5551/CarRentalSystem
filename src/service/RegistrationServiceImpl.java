package service;

import exceprion.CustomGenericException;
import file.WriteFile;
import model.User;
import validator.SighUpValidator;

import java.util.*;

public class RegistrationServiceImpl implements RegistrationService {
    private Map<String, String> hashmap = new HashMap<String, String>();

    @Override
    public void create() throws CustomGenericException {
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
            e.printStackTrace();
        } finally {
            writeFile.writeItem(user,"User.txt");
        }
    }
}

