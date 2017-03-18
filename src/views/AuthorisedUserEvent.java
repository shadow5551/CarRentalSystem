package views;

import model.User;

import java.util.Scanner;

/**
 * Created by dima on 16.3.17.
 */
public class AuthorisedUserEvent {
    private Scanner scanner = new Scanner(System.in);

    public boolean getAuthorisedUserEvent(User user) {
        boolean flag = true;
        String choice;
        while (flag) {
            getAuthorizedUserAbilities();
            flag = true;
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    bookingNewCar();
                    break;
                case "2":
                    payForDamage();
                    break;
                case "3":
                    bookedCar();
                    break;
                case "4":
                    flag = false;
                    break;
                default:
                    System.out.println("Введена неправильная позиция!");
            }
        }
        return true;
    }


    private void bookingNewCar() {
        System.out.println("бронь");

    }

    private void payForDamage(){
        System.out.println("pay");
    }

    private void bookedCar(){
        System.out.println("Забронированные авто");
    }
    private void getAuthorizedUserAbilities(){
        System.out.println("1.Забронировать машину");
        System.out.println("2.Оплатить повреждения");
        System.out.println("3.Взятые в прокат авто");
        System.out.println("3.Выход");
    }
}
