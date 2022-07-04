package com.alper.springbootsmaros.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Timesheets")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "UserID")
    private long userID;

    @Column(name = "timesheetdate")
    private Date timesheetdate;

    @Column(name = "duration" , precision = 4 , scale = 2)
    private double duration;

    @Column(name = "location" , length = 50)
    private String location;

    @Column(name = "taskID")
    private  long taskID;

    @Column(name = "description")
    private String description;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreateUser")
    private String createUser;

    public Timesheet(){
    }

    public Timesheet(long userID, Date timesheetdate, double duration, String location, long taskID, String description , Date createDate, String createUser) {
        //this.id = id;
        this.userID = userID;
        this.timesheetdate = timesheetdate;
        this.duration = duration;
        this.location = location;
        this.taskID = taskID;
        this.description = description;
        this.createDate = createDate;
        this.createUser = createUser;
    }


    public long getId() {
        return id;
    }

    /*public void setId(long id) {
        this.id = id;
    }*/

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public Date getTimesheetdate() {
        return timesheetdate;
    }

    public void setTimesheetdate(Date timesheetdate) {
        this.timesheetdate = timesheetdate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getTaskID() {
        return taskID;
    }

    public void setTaskID(long taskID) {
        this.taskID = taskID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "Timesheet{" +
                "id=" + id +
                ", userID=" + userID +
                ", timesheetdate=" + timesheetdate +
                ", duration=" + duration +
                ", location='" + location + '\'' +
                ", taskID=" + taskID +
                ", createDate=" + createDate +
                ", createUser='" + createUser + '\'' +
                '}';
    }
}
