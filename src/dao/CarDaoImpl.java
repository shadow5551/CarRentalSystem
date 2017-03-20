package dao;

import file.ReadFile;
import file.WriteFile;
import model.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dima on 19.3.17.
 */
public class CarDaoImpl implements CarDao{
    private Map<String, String> hashmap = new HashMap<>();

    @Override
    public List<Car> getAll() {
        ReadFile readFile = new ReadFile();
        readFile.readItem("Car.txt");
        return readFile.getCarList();
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public boolean delete(Car car) {
        return false;
    }

    @Override
    public boolean create() {
        Car car = null;
        WriteFile writeFile = new WriteFile();
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Марка");
            hashmap.put("brand", in.next());
            System.out.println("Модель");
            hashmap.put("model", in.next());
            car = new Car(hashmap.get("brand"), hashmap.get("model"));
        } catch (Exception e) {
            return false;
        } finally {
            writeFile.writeItem(car,"Car.txt");
        }
        return true;
    }
}
