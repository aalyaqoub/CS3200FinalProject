package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="enrollments")
public class Enrollment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "user_id")
  private User enrolledUser;
  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "course_id") // do I need this??
  private Course courseEnrollment;
  private Integer grade;

  // getters and setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getEnrolledUser() {
    return enrolledUser;
  }

  public void setEnrolledUser(User enrolledUser) {
    this.enrolledUser = enrolledUser;
  }

  public Course getCourseEnrollment() {
    return courseEnrollment;
  }

  public void setCourseEnrollment(Course courseEnrollment) {
    this.courseEnrollment = courseEnrollment;
  }

  public Integer getGrade() {
    return grade;
  }

  public void setGrade(Integer grade) {
    this.grade = grade;
  }
}
