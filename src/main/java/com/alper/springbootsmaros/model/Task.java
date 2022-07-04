package com.alper.springbootsmaros.model;


import javax.persistence.*;

@Entity
@Table(name = "Tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name" , length = 50)
    private String name;

    @Column(name = "description" , length = 100)
    private String description;



    public Task(){
    }

    public Task(String name , String description) {
        //this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name = '" + name + '\''+
                ", description='" + description + '\'' +
                '}';
    }


}
