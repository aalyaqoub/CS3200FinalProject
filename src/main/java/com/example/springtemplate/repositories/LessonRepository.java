package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Lesson;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
  @Query(value = "SELECT * FROM lessons",
          nativeQuery = true)
  public List<Lesson> findAllLessons();
  @Query(value = "SELECT * FROM lessons WHERE id=:lessonId",
          nativeQuery = true)
  public Lesson findLessonById(@Param("lessonId") Integer id);

  @Modifying
  @Transactional
  @Query(value = "UPDATE lessons SET course_id=:courseId WHERE id=:lessonId",
          nativeQuery = true)
  public void updateCourse(@Param("lessonId") Integer id, @Param("courseId") Integer ownerId);

  @Query(value = "SELECT lessons.course_id FROM lessons WHERE id=:lessonId",
          nativeQuery = true)
  public Integer findCourse(@Param("lessonId") Integer id);

  @Query(value = "SELECT * FROM lessons WHERE course_id=:courseId",
          nativeQuery = true)
  public List<Lesson> findCourseLessons(@Param("courseId") Integer id);

}
