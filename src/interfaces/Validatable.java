package interfaces;

import java.util.Map;

/**
 * Created by dima on 16.3.17.
 */
public interface Validatable {
    boolean validate(Map<String, String> hashmap) throws Exception;
    boolean validateFromFile(Map<String, String> hashmap) throws Exception;
}
