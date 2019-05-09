package com.system.kuet.bashabodol;

import java.util.WeakHashMap;

public class Data {
    public String uid;
    public  String name;
    public String phonenumber;
    public String address;
    public String bed;
    public String chair;
    public String fridge;
    public String showcase;
    public String wardrobe;

    public Data(){

    }
    public Data(String uid,String name, String phonenumber, String address, String bed, String chair, String fridge, String showcase, String wardrobe) {
        this.uid = uid;
        this.name = name;
        this.phonenumber = phonenumber;
        this.address = address;
        this.bed = bed;
        this.chair = chair;
        this.fridge = fridge;
        this.showcase = showcase;
        this.wardrobe = wardrobe;

    }

    public String getuid() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public String getFridge() {
        return fridge;
    }

    public void setFridge(String fridge) {
        this.fridge = fridge;
    }

    public String getShowcase() {
        return showcase;
    }

    public void setShowcase(String showcase) {
        this.showcase = showcase;
    }

    public String getWardrobe() {
        return wardrobe;
    }

    public void setWardrobe(String wardrobe) {
        this.wardrobe = wardrobe;
    }

}
