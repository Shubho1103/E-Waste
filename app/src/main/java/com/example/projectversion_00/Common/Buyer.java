package com.example.projectversion_00.Common;

public class Buyer {

    private String name,uid,phn,email,locality;
    private Integer weight,bid;

    public Buyer() {
    }

    public Buyer(String name, String uid, String phn, String email, String locality, Integer weight, Integer bid) {
        this.name = name;
        this.uid = uid;
        this.phn = phn;
        this.email = email;
        this.locality = locality;
        this.weight = weight;
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public String getPhn() {
        return phn;
    }

    public String getEmail() {
        return email;
    }

    public String getLocality() {
        return locality;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getBid() {
        return bid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }
}
