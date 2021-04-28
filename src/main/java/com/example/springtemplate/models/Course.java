package com.example.springtemplate.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "course_name")
    private String courseName;
    @Enumerated(EnumType.STRING)
    private Topic topic;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "owner")
    private User owner;
    @Column(name = "owner", insertable = false, updatable = false)
    private Integer ownerId;
    @OneToMany(mappedBy = "courseEnrollment")
    private List<Enrollment> enrolledUsers;
    @OneToMany(mappedBy = "courseLesson")
    private List<Lesson> lessons;

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    //    public Integer getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Integer owner) {
//        this.owner = owner;
//    }

    public List<Enrollment> getEnrolledUsers() {
        return enrolledUsers;
    }

    public void setEnrolledUsers(List<Enrollment> enrolledUsers) {
        this.enrolledUsers = enrolledUsers;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}


