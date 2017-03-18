package views;

import model.User;
import service.LoginServiceImpl;
import service.RegistrationServiceImpl;

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

            }
        }else {
            authorization();
        }
    }

    private void registration() {
        RegistrationServiceImpl registrationServiceImpl = new RegistrationServiceImpl();
        try {
            registrationServiceImpl.create();
        } catch (Exception e) {
            System.out.println("Не удалось создать пользователя");
        }
        System.out.println("Пользователь успешно создан");
    }

    private void getUnauthorizedUserAbilities() {
        System.out.println("1.Авторизироваться");
        System.out.println("2.Зарегистрироваться");
        System.out.println("3.Выход");
    }

}
