package com.example.demo.collection.list;
import java.util.*;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    private int e_id;
    private String e_name;
//表示嵌入对象
    @ElementCollection
    private List<Address> address = new ArrayList<Address>();

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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }


}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-list-mapping.html#article-start
