package views;

import dao.UserDaoImpl;
import model.User;
import service.LoginServiceImpl;

import java.io.File;
import java.util.Scanner;

/**
 * Created by dima on 16.3.17.
 */
public class UnauthorisedUserEvent {
    private Scanner scanner = new Scanner(System.in);

    public boolean getUnauthorisedUserEvent() {
        boolean flag = true;
        getUnauthorizedUserAbilities();
        String choice;
        while (flag) {
            flag = true;
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    authorization();
                    getUnauthorizedUserAbilities();
                    break;
                case "2":
                    registration();
                    getUnauthorizedUserAbilities();
                    break;
                case "3":
                    flag = false;
                    break;
                default:
                    System.out.println("Введена неправильная позиция!");
            }
        }
        return true;
    }

    private void authorization() {
        User user;
        LoginServiceImpl loginService = new LoginServiceImpl();
        user = loginService.getCurrentUser();
        if (user!=null){
            if (user.getRole().equals("user")){
            AuthorisedUserEvent authorisedUserEvent = new AuthorisedUserEvent();
            authorisedUserEvent.getAuthorisedUserEvent(user);}
            else{
                AuthorisedAdminEvent authorisedAdminEvent = new AuthorisedAdminEvent();
                authorisedAdminEvent.getAuthorisedAdminEvent(user);
            }
        }else {
            authorization();
        }
    }

    private void registration() {
        UserDaoImpl userDao = new UserDaoImpl();
        if (!userDao.create()){
            System.out.println("Не удалось создать пользователя");
        }else {
            System.out.println("Пользователь успешно создан");
        }

    }

    private void getUnauthorizedUserAbilities() {
        System.out.println("1.Авторизироваться");
        System.out.println("2.Зарегистрироваться");
        System.out.println("3.Выход");
    }

}
