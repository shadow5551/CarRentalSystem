package file;

import interfaces.Writer;
import model.Order;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by dima on 16.3.17.
 */
public class WriteFile implements Writer {
    private Logger logger = Logger.getLogger(WriteFile.class.getName());

    @Override
    public void writeItem(Object object, String nameOfFile) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nameOfFile));
            out.writeObject(object);
            out.close();
        } catch (IOException ex) {
            logger.warning(ex.getMessage());
        }
    }

    @Override
    public void writeCollection(List<Order> list, String nameOfFile) {
        for (Order order:list){
            writeItem(order,nameOfFile);
        }
    }

}
