package registration;

import file.ReadFile;
import interfaces.Validatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dima on 16.3.17.
 */
public class ValidateRegistrationForm implements Validatable {
    private Pattern patternLogin = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$");
    private Pattern patternPassword = Pattern.compile("[a-zA-Z0-9]{8,20}");
    private Pattern patternPassport = Pattern.compile("^[a-zA-Z]{2}[0-9]{7}$");
    private List<User> userList = new ArrayList<>();


    @Override
    public boolean validate(Map<String, String> hashmap) throws Exception {
        Matcher matcherLogin = patternLogin.matcher(hashmap.get("login"));
        Matcher matcherPassword = patternPassword.matcher(hashmap.get("password"));
        Matcher matcherPassport = patternPassport.matcher(hashmap.get("passport"));
        if (!matcherLogin.matches()) {
            System.out.println("Проблема с логином. Ограничение от 2 до 20 символов, которыми могут быть " +
                    "буквы и цифры, первый символ обязательно буква");
            return false;
        }
        if (!matcherPassword.matches()) {
            System.out.println("Проблема с паролем. Минимум 8 символов. Максимум 64. Может состоять из цифр " +
                    "и букв латинского алфавита ");
            return false;
        }
        if (!matcherPassport.matches()) {
            System.out.println("Проблема с паспортом. Первые 2 буквы заглавные латинского " +
                    "алфавита , остальные семь -- цифры");
            return false;
        }
        return validateFromFile(hashmap);
    }

    @Override
    public boolean validateFromFile(Map<String, String> hashmap) throws Exception {
        ReadFile readFile = new ReadFile();
        userList = readFile.readUsers("USERS.TXT");
        for (User user : userList) {
            if (user.getLogin().equals(hashmap.get("login"))) {
                System.out.println("Такой логин уже присутствует в системе");
                return false;
            }
            if (user.getNumberOfPassport().equals(hashmap.get("passport"))) {
                System.out.println("Такой паспорт уже присутствует в системе");
                return false;
            }

        }
        return true;
    }
}

