package com.example.demo.student;
import javax.persistence.*;

@Entity
@Table(name = "student_entity")
public class Student {

    @Id
    private int s_id;
    private String s_name;
    private int s_age;

    public Student(int s_id, String s_name, int s_age) {
        super();
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_age = s_age;
    }

    public Student() {
        super();
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getS_age() {
        return s_age;
    }

    public void setS_age(int s_age) {
        this.s_age = s_age;
    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-finding-an-entity.html#article-start

