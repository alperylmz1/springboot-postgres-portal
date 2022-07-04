package com.alper.springbootsmaros.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name" , length = 50)
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "status" , length = 1)
    private String status;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreateUser")
    private String createUser;

    public Customer(){
    }

    public Customer(String name, String location, String status, Date createDate, String createUser) {
        //this.id = id;
        this.name = name;
        this.location = location;
        this.status = status;
        this.createDate = createDate;
        this.createUser = createUser;
    }

    public long getId() {
        return id;
    }

    /*public void setId(long id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", createUser='" + createUser + '\'' +
                '}';
    }
}
