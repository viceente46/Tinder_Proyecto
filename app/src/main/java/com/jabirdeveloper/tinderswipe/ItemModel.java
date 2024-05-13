package com.jabirdeveloper.tinderswipe;

import java.io.Serializable;

public class ItemModel implements Serializable {
    private int image;
    private String name;
    private String age;
    private String location;
    private String phoneNumber;
    private String instagram;

    public ItemModel(int image, String name, String age, String location, String phoneNumber, String instagram) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.instagram = instagram;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
// getters y setters para phoneNumber e instagram

    // Resto del código...
}


