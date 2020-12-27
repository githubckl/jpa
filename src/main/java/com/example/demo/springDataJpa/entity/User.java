package com.example.demo.springDataJpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "age")
    private Integer age;

    @ManyToMany(targetEntity = Role.class,cascade = CascadeType.ALL)
    //     配置中间表的注解
    @JoinTable(name = "user_role",
//            当前对象在中间表的外键
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
//            对方对象的中间表的外键
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private Set<Role> roles = new HashSet<Role>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
