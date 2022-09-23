package com.example.projectversion_00.Common;

public class model {

    String locality,desc;
    Integer weight;

    public model() {
    }

    public model(String locality,String desc,Integer weight) {
        this.locality = locality;
        this.weight=weight;
        this.desc=desc;

    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
    public String getLocality() {
        return locality;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
