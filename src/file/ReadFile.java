package file;


import model.Car;
import interfaces.Reader;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 15.3.17.
 */

public class ReadFile implements Reader,Serializable {
    private List<User> userList = new ArrayList<>();
    private List<Car> carList = new ArrayList<>();

    @Override
    public void readItem(String nameOfFile) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nameOfFile));
            while (true) {
                try {
                    if (nameOfFile.equals("User.txt")){
                        userList.add((User) in.readObject());
                    }
                    if (nameOfFile.equals("Car.txt")){
                        carList.add((Car) in.readObject());
                    }
                } catch (ClassNotFoundException e) {
                    break;
                }
            }
        } catch (FileNotFoundException | EOFException ignored) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<User> getUserList() {
        return userList;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
