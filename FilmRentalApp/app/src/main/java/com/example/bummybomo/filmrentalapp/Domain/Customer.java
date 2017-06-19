package com.example.bummybomo.filmrentalapp.Domain;

import java.io.Serializable;

/**
 * Created by jordanh2os on 16/06/2017.
 */

public class Customer implements Serializable {
    private int customerId;
    private int storeId;
    private String firstName;
    private String lastName;
    private String email;
    private int adresId;
    private int activeCheck;
    private String createDate;
    private String lastUpdate;
    private String password;

    public Customer(int customerId, int storeId, String firstName, String lastName, String email, int adresId, int activeCheck, String createDate, String lastUpdate, String password) {
        this.customerId = customerId;
        this.storeId = storeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adresId = adresId;
        this.activeCheck = activeCheck;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAdresId() {
        return adresId;
    }

    public void setAdresId(int adresId) {
        this.adresId = adresId;
    }

    public int getActiveCheck() {
        return activeCheck;
    }

    public void setActiveCheck(int activeCheck) {
        this.activeCheck = activeCheck;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

