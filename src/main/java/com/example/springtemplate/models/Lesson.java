package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="lessons")
public class Lesson {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;
  private String text;
  @Column(name = "video_link")
  private String videoLink;
  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "course_id")
  private Course courseLesson;
  @Column(name = "course_id", insertable = false, updatable = false)
  private Integer courseId;

  // getters and setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String tet) {
    this.text = tet;
  }

  public String getVideoLink() {
    return videoLink;
  }

  public void setVideoLink(String videoLink) {
    this.videoLink = videoLink;
  }

  public Course getCourseLesson() {
    return courseLesson;
  }

  public void setCourseLesson(Course courseLesson) {
    this.courseLesson = courseLesson;
  }

  public Integer getCourseId() {
    return courseId;
  }

  public void setCourseId(Integer courseId) {
    this.courseId = courseId;
  }
}
