package com.example.demo.collection.list;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private int e_pincode;
    private String e_city;
    private String e_state;

    public int getE_pincode() {
        return e_pincode;
    }

    public void setE_pincode(int e_pincode) {
        this.e_pincode = e_pincode;
    }

    public String getE_city() {
        return e_city;
    }

    public void setE_city(String e_city) {
        this.e_city = e_city;
    }

    public String getE_state() {
        return e_state;
    }

    public void setE_state(String e_state) {
        this.e_state = e_state;
    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-list-mapping.html#article-start

