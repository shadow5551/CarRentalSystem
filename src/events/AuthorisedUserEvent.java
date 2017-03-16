package events;

import java.util.Scanner;

/**
 * Created by dima on 16.3.17.
 */
public class AuthorisedUserEvent {
    private Scanner scanner = new Scanner(System.in);

    public boolean getAuthorisedUserEvent() {
        boolean flag = true;
        getAuthorizedUserAbilities();
        String choice;
        while (flag) {
            flag = true;
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    bookingCar();
                    getAuthorizedUserAbilities();
                    break;
                case "2":
                    returnCar();
                    getAuthorizedUserAbilities();
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

    private void returnCar() {

    }

    private void bookingCar() {

    }

    private void getAuthorizedUserAbilities(){
        System.out.println("1.Забронировать машину");
        System.out.println("2.Вернуть машину");
        System.out.println("3.Оплатить повреждения");
    }
}
