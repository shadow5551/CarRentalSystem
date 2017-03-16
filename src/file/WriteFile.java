package file;

import interfaces.Writer;
import registration.User;

import java.io.*;
import java.util.logging.Logger;

/**
 * Created by dima on 16.3.17.
 */
public class WriteFile implements Writer {
    private Logger logger = Logger.getLogger(WriteFile.class.getName());

    @Override
    public void writeUser(User user, String nameOfFile) {
        if (new File(nameOfFile).exists()) {
            File f = new File(nameOfFile);
        } else {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nameOfFile));
                out.writeObject(user);
                out.close();
            } catch (IOException ex) {
                logger.warning(ex.getMessage());
            }

        }
    }
}
