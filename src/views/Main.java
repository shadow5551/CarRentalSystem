package views;


/**
 * Created by dima on 14.3.17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Система для проката автомобилей");
        UnauthorisedUserEvent userEvent = new UnauthorisedUserEvent();
        while (!userEvent.getUnauthorisedUserEvent()) {
            userEvent.getUnauthorisedUserEvent();
        }
        System.out.println("Система для проката автомобилей завершена");
    }
}
