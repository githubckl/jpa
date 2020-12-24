package com.example.demo.collection.map;

import java.util.*;

import javax.persistence.*;

@Entity

public class Employee2 {

    @Id
    private int e_id;
    private String e_name;

    @ElementCollection
    private Map<Integer, Address> map = new HashMap<Integer, Address>();

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public Map<Integer, Address> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Address> map) {
        this.map = map;
    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-map-mapping.html#article-start

