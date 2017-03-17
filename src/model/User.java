package model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by dima on 16.3.17.
 */
public class User implements Serializable {
    private String login;
    private String password;
    private String numberOfPassport;


    public User(String login, String password, String numberOfPassport) {
        this.login = login;
        this.password = password;
        this.numberOfPassport = numberOfPassport;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumberOfPassport() {
        return numberOfPassport;
    }

    public void setNumberOfPassport(String numberOfPassport) {
        this.numberOfPassport = numberOfPassport;
    }


    @Override
    public String toString() {
        return String
                .format("login: %5s password: %5s numberofPassport: %5s", login, password, numberOfPassport);
    }
}
