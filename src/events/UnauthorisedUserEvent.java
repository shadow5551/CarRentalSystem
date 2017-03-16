package events;

import registration.RegistrationUser;

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
        System.out.println("Авторизация прошла успешно , Здравствуйте пользователь");
    }

    private void registration() {
        RegistrationUser registrationUser = new RegistrationUser();
        try {
            registrationUser.create();
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
