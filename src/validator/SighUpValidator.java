package validator;

import dao.UserDaoImpl;
import exceprion.CustomGenericException;
import file.ReadFile;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dima on 16.3.17.
 */
public class SighUpValidator implements Validatable {
    private Pattern patternLogin = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$");
    private Pattern patternPassword = Pattern.compile("[a-zA-Z0-9]{8,20}");
    private Pattern patternPassport = Pattern.compile("^[a-zA-Z]{2}[0-9]{7}$");


    @Override
    public boolean validate(Object object) throws CustomGenericException {
        User user = (User) object;
        UserDaoImpl userDao = new UserDaoImpl();

        Matcher matcherLogin = patternLogin.matcher(user.getLogin());
        Matcher matcherPassword = patternPassword.matcher(user.getPassword());
        Matcher matcherPassport = patternPassport.matcher(user.getNumberOfPassport());
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
        if (!user.getRole().equals("admin") && !user.getRole().equals("user")){
            System.out.println("Неверная роль");
            return false;
        }
        return userDao.isValidUser(user);
    }
}

