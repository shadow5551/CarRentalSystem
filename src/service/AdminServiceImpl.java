package service;

import file.WriteFile;
import model.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dima on 18.3.17.
 */
public class AdminServiceImpl implements  AdminService {
    private Map<String, String> hashmap = new HashMap<String, String>();

    @Override
    public void issueInvoice() {

    }

    @Override
    public void addNewCar() {
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
            e.printStackTrace();
        } finally {
            writeFile.writeItem(car,"Car.txt");
        }
    }
}
