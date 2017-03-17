package interfaces;

import exceprion.CustomGenericException;
import model.User;

import java.util.Map;

/**
 * Created by dima on 16.3.17.
 */
public interface Validatable {
    boolean validate(Object object) throws CustomGenericException;

    boolean validateFromFile(User currentUser) throws CustomGenericException;
}
