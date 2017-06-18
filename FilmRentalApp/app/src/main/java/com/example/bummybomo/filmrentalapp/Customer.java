

package com.example.bummybomo.filmrentalapp;
import java.io.Serializable;

/**
 * Created by Omidleet on 16/06/2017.
 */

public class Customer implements Serializable {
    private int customerId;
    private String username, password;

    public Customer(int customerId, String username, String password) {
        this.customerId = customerId;
        this.username = username;
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
