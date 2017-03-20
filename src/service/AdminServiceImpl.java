package service;

import dao.CarDao;
import dao.CarDaoImpl;
import dao.OrderDaoImpl;
import exceprion.CustomGenericException;
import file.WriteFile;
import model.Car;
import model.Order;

import java.util.*;

/**
 * Created by dima on 18.3.17.
 */
public class AdminServiceImpl implements  AdminService {
    private CarDaoImpl carDao = new CarDaoImpl();
    private List<Order> orderList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public boolean addNewCar() throws CustomGenericException {
        if (!carDao.create()){
            return false;
        }else return true;
    }

    @Override
    public void userOrders() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderList = orderDao.getAll();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер заказа:");
        do
        {
            if (in.hasNextInt()) {
                int idOrder = in.nextInt()+1;
                if ((orderList.size() < idOrder) || (idOrder < 0)) {
                    System.out.println("Повторите ввод");
                } else {
                    actionWithOrder(orderList.get(idOrder),idOrder);
                    break;
                }
            }
        }while(true);
    }

    private void actionWithOrder(Order order,int idOrder) {
        WriteFile writeFile = new WriteFile();
        writeFile.delete("Order.txt");
        info();
        boolean flag = true;
        String choice;
        while (flag) {
            flag = true;
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    applyOrder(order,idOrder);
                    break;
                case "2":
                    refuseOrder(order,idOrder);
                    break;
                case "3":
                    issueInvoice(order,idOrder);
                    break;
                case "4":
                    flag = false;
                    break;
                default:
                    System.out.println("Введена неправильная позиция!");
            }
        }
    }


    public void issueInvoice(Order order, int idOrder) {
        System.out.print("Введите счет за ремонт ");
        while (!scanner.hasNextInt()) scanner.next();
        int price = scanner.nextInt();
        System.out.println("Укажите причину взымания платы");
        order.setStatus(scanner.next() + price + "$");
        orderList.set(idOrder,order);
        saveChanges();
    }

    private void refuseOrder(Order order, int idOrder) {
        System.out.println("Укажите причину отказа");
        order.setStatus("refused(reason:"+scanner.next()+")");
        orderList.set(idOrder,order);
        saveChanges();
    }

    void applyOrder(Order order, int idOrder){
        order.setStatus("accepted");
        orderList.set(idOrder,order);
        saveChanges();
    }

    void saveChanges(){
        WriteFile writeFile = new WriteFile();
        writeFile.writeCollection(orderList,"Order.txt");
    }

    void info(){
        System.out.println("Выберите что сделать с заказом");
        System.out.println("1.разрешить");
        System.out.println("2.отказать");
        System.out.println("3.выставить счет");
    }


}
