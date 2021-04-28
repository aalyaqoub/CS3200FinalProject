package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(name = "dob")
    private Date dateOfBirth;
    private String username;
    private String password;
    private String email;
    private Date created;
    private Date updated;
    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private List<Course> ownedCourses;
    @OneToMany(mappedBy = "enrolledUser")
    private List<Enrollment> enrolledCourses;


    //    public User(String username, String password, String first_name, String last_name, String profile_picture) {
//        this.username = username;
//        this.password = password;
//        this.firstName = first_name;
//        this.lastName = last_name;
//        this.profilePicture = profile_picture;
//    }
//
//    public User() {}

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public List<Course> getOwnedCourses() {
        return ownedCourses;
    }

    public void setOwnedCourses(List<Course> ownedCourses) {
        this.ownedCourses = ownedCourses;
    }

    public List<Enrollment> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Enrollment> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
