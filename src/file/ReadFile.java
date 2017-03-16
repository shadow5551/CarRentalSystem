package file;


import interfaces.Reader;
import registration.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 15.3.17.
 */

public class ReadFile implements Reader {
    private List<User> usersList = new ArrayList<>();

    @Override
    public List<User> readUsers(String nameOfFile) throws Exception {
        if (new File(nameOfFile).exists()) {
            File f = new File(nameOfFile);
        } else {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(nameOfFile));
                while (true) {
                    try {
                        usersList.add((User) in.readObject());
                    } catch (Exception ignored) {
                        return usersList;
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("Не найден файл");
            } catch (EOFException ignored) {
            }
            return usersList;
        }
        return null;
    }
}
