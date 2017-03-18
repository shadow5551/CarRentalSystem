package service;

import file.ReadFile;
import model.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by dima on 18.3.17.
 */
public abstract class HumanService {
    private List<Car> carList = new ArrayList<>();
    private ReadFile readFile = new ReadFile();

    List<Car> getCars() {
        readFile.readItem("Car.txt");
        carList = readFile.getCarList();
        return carList;
    }
}
