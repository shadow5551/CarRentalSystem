package registration;

import file.WriteFile;

import java.util.*;

public class RegistrationUser extends Registration {
    private Map<String, String> hashmap = new HashMap<String, String>();

    @Override
    public void create() throws Exception {
        User user = null;
        WriteFile writeFile = new WriteFile();
        Scanner in = new Scanner(System.in);
        ValidateRegistrationForm validateRegistrationForm = new ValidateRegistrationForm();
        try {
            do {
                System.out.println("Логин");
                hashmap.put("login", in.next());
                System.out.println("Пароль");
                hashmap.put("password", in.next());
                System.out.println("Паспорт");
                hashmap.put("passport", in.next());
            } while (!validateRegistrationForm.validate(hashmap));
            user = new User(hashmap.get("login"), hashmap.get("password"), hashmap.get("passport"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeFile.writeUser(user,"USERS.TXT");
        }
    }
}

