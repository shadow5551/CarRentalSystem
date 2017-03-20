package dao;

import file.ReadFile;
import file.WriteFile;
import model.Order;
import model.User;
import validator.OrderValidator;

import java.util.*;

/**
 * Created by dima on 20.3.17.
 */
public class OrderDaoImpl implements OrderDao {
    private Map<String, String> hashmap = new HashMap<>();
    private Scanner in = new Scanner(System.in);


    @Override
    public List<Order> getAll() {
        ReadFile readFile = new ReadFile();
        readFile.readItem("Order.txt");
        return readFile.getOrderList();
    }

    @Override
    public boolean create(User currentUser) {
        List<Order> orderList = getAll();
        Order order = null;
        WriteFile writeFile = new WriteFile();
        Calendar calendar = new GregorianCalendar();
        Date currentDate = calendar.getTime();
        calendar.setTime(currentDate);
        OrderValidator orderValidator = new OrderValidator();
        try {
            do {
                System.out.println("Напишите марку машины");
                hashmap.put("brand", in.next());
                System.out.println("Напишите модель машины");
                hashmap.put("model", in.next());
                System.out.println("Выберите количество дней");
                while (!in.hasNextInt()) in.next();
                hashmap.put("countOfDays", String.valueOf(in.nextInt()));
                calendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(hashmap.get("countOfDays")));
                order = new Order(orderList.size()+1,currentUser.getLogin(), hashmap.get("brand"), hashmap.get("model"),calendar.getTime(),"process");
            } while (!orderValidator.validate(order));
        } catch (Exception e) {
            return false;
        } finally {
            writeFile.writeItem(order,"Order.txt");
        }
        return true;
    }

    @Override
    public Order update(Order order) {
        return null;
    }
}
