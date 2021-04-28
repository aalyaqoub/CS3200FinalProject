package com.example.springtemplate.daos;

import com.example.springtemplate.models.Course;
import com.example.springtemplate.models.Lesson;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.CourseRepository;
import com.example.springtemplate.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LessonOrmDao {
  @Autowired
  LessonRepository lessonRepository;
  @Autowired
  CourseRepository courseRepository;

  @PostMapping("/api/lessons")
  public Lesson createLesson(@RequestBody Lesson lesson) {
    Course givenCourse = findCourseById(lesson.getCourseId());
    lesson.setCourseLesson(givenCourse);
    return lessonRepository.save(lesson);

  }

  @GetMapping("/api/lessons")
  public List<Lesson> findAllLessons() {
    return lessonRepository.findAllLessons();
  }

  @GetMapping("/api/lessons/{lessonId}")
  public Lesson findLessonById(
          @PathVariable("lessonId") Integer id) {
    return lessonRepository.findLessonById(id);
  }

  @GetMapping("/api/update/lesson/{lessonId}/{title}")
  public Lesson updateLesson(
          @PathVariable("lessonId") Integer id,
          @PathVariable("title") String newTitle) {
    Lesson lesson = this.findLessonById(id);
    lesson.setTitle(newTitle);
    return lessonRepository.save(lesson);
  }

  @PutMapping("/api/lessons/{lessonId}")
  public Lesson updateLesson(
          @PathVariable("lessonId") Integer id,
          @RequestBody() Lesson newLesson) {
    Lesson lesson = this.findLessonById(id);
    lesson.setTitle(newLesson.getTitle());
    lesson.setText(newLesson.getText());
    lesson.setVideoLink(newLesson.getVideoLink());
    return lessonRepository.save(lesson);
  }

  @GetMapping("/api/lessons/{lessonId}/delete")
  public Integer deleteLesson(
          @PathVariable("lessonId") Integer id) {
    lessonRepository.deleteById(id);
    return 1;
  }

  @GetMapping("/api/lessons/{lessonId}/{courseId}")
  public Integer updateOwner(
          @PathVariable("lessonId") Integer id,
          @PathVariable("courseId") Integer courseId) {
    lessonRepository.updateCourse(id, courseId);
    return 1;
  }

  @GetMapping("/api/lessons/{lessonId}/course")
  public Integer findLesson(
          @PathVariable("lessonId") Integer id) {
    return lessonRepository.findCourse(id);
  }

  @GetMapping("/api/lessons/{courseId}/find")
  public Course findCourseById(
          @PathVariable("courseId") Integer id) {
    return courseRepository.findCourseById(id);
  }
}
