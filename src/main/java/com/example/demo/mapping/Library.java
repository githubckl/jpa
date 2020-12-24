package com.example.demo.mapping;
import javax.persistence.*;

@Entity
public class Library {
    @Id
    private int b_id;
    private String b_name;

    @OneToOne
    private Students stud;

    public Library(int b_id, String b_name, Students stud) {
        super();
        this.b_id = b_id;
        this.b_name = b_name;
        this.stud = stud;
    }

    public Library() {
        super();

    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public Students getStud() {
        return stud;
    }

    public void setStud(Students stud) {
        this.stud = stud;
    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-one-to-one-mapping.html

