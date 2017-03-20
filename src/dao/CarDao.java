package dao;

import model.Car;

import java.util.List;

/**
 * Created by dima on 19.3.17.
 */
public interface CarDao {
    List<Car> getAll();
    Car update(Car car);//при подключении к бд поменять на ключ сущности
    boolean delete(Car car);
    boolean create();
}
