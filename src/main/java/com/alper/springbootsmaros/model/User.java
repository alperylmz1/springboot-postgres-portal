package com.alper.springbootsmaros.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Users")
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "status" , length = 1)
    private String status;

    @Column(name = "role" , length = 10)
    private String role;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreateUser")
    private String createUser;


    public User(){
    }


    public User(long id, String email, String name, String status, String role, Date createDate, String createUser) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.status = status;
        this.role = role;
        this.createDate = createDate;
        this.createUser = createUser;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                ", createDate=" + createDate +
                ", createUser='" + createUser + '\'' +
                '}';
    }
}
