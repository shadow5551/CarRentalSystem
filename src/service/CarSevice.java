package service;

import model.Car;

import java.util.Collection;
import java.util.List;

/**
 * Created by dima on 17.3.17.
 */
public interface CarSevice {
    void bookCar(Car entity);
    Collection<Car> getCars(String search);
}
