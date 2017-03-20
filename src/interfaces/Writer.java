package interfaces;

import model.Order;

import java.util.List;

/**
 * Created by dima on 15.3.17.
 */
public interface Writer {
    void writeItem(Object object, String nameOfFile);
    void writeCollection(List<Order> list, String nameOfFile);
}
