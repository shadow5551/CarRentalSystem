package validator;

import dao.CarDaoImpl;
import exceprion.CustomGenericException;
import model.Car;
import model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 19.3.17.
 */
public class OrderValidator implements Validatable {
    @Override
    public boolean validate(Object object) throws CustomGenericException {
        Order order = (Order) object;
        CarDaoImpl carDao = new CarDaoImpl();
        List<Car> carList = carDao.getAll();
        for (Car car: carList){
            if (car.getBrand().equals(order.getBrand()) && car.getModel().equals(order.getModel())){
                System.out.println("Заказ дабавлен");
                return true;
            }else {
                System.out.println("Нет такой машины в наличии");
                return false;
            }
        }
        return false;
    }
}
