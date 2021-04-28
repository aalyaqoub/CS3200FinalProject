package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseRepository
        extends CrudRepository<Course, Integer> {
  @Query(value = "SELECT * FROM courses",
          nativeQuery = true)
  public List<Course> findAllCourses();
  @Query(value = "SELECT * FROM courses WHERE id=:courseId",
          nativeQuery = true)
  public Course findCourseById(@Param("courseId") Integer id);

  @Modifying
  @Transactional
  @Query(value = "UPDATE courses SET owner=:ownerId WHERE id=:courseId",
          nativeQuery = true)
  public void updateOwner(@Param("courseId") Integer id, @Param("ownerId") Integer ownerId);

  @Query(value = "SELECT courses.owner FROM courses WHERE id=:courseId",
          nativeQuery = true)
  public Integer findOwner(@Param("courseId") Integer id);

  @Query(value = "SELECT * FROM courses WHERE owner=:ownerId",
          nativeQuery = true)
  public List<Course> findOwnedCourses(@Param("ownerId") Integer id);
}
