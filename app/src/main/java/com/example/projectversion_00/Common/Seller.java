package com.example.projectversion_00.Common;

public class Seller {

    private String name,uid,phn,email,exctloc,locality,desc;
    private Integer weight;

    public Seller(){

    }

    public Seller(String name, String uid, String phn, String email, String exctloc, String locality, Integer weight, String desc){
        this.name=name;
        this.uid=uid;
        this.phn=phn;
        this.email=email;
        this.exctloc=exctloc;
        this.locality=locality;
        this.weight=weight;
        this.desc=desc;
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

    public String getExctloc() {
        return exctloc;
    }

    public String getLocality() {
        return locality;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getWeight() {
        return weight;
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

    public void setExctloc(String exctloc) {
        this.exctloc = exctloc;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
