package service;

import exceprion.CustomGenericException;
import file.WriteFile;
import model.Car;

import java.util.*;

/**
 * Created by dima on 18.3.17.
 */
public class AdminServiceImpl extends HumanService implements  AdminService {
    private Map<String, String> hashmap = new HashMap<String, String>();

    @Override
    public void issueInvoice() {

    }

    @Override
    public boolean addNewCar() throws CustomGenericException {
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


    @Override
    public List<Car> getCars() {
        return super.getCars();
    }
}
