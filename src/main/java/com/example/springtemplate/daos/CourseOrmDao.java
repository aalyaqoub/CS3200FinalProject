package com.example.springtemplate.daos;

import com.example.springtemplate.models.Course;
import com.example.springtemplate.models.Lesson;
import com.example.springtemplate.models.Topic;
import com.example.springtemplate.repositories.LessonRepository;
import com.example.springtemplate.repositories.UserRepository;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CourseOrmDao {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LessonRepository lessonRepository;

    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody Course course) {
        User givenUser = findUserById(course.getOwnerId());
        course.setOwner(givenUser);
        return courseRepository.save(course);
    }

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return courseRepository.findAllCourses();
    }

    @GetMapping("/api/courses/{courseId}")
    public Course findCourseById(
            @PathVariable("courseId") Integer id) {
        return courseRepository.findCourseById(id);
    }

    @GetMapping("/api/update/course/{courseId}/{topic}")
    public Course updateCourse(
            @PathVariable("courseId") Integer id,
            @PathVariable("topic") Topic newTopic) {
        Course course = this.findCourseById(id);
        course.setTopic(newTopic);
        return courseRepository.save(course);
    }

    @PutMapping("/api/courses/{courseId}")
    public Course updateCourse(
            @PathVariable("courseId") Integer id,
            @RequestBody() Course newCourse) {
        Course course = this.findCourseById(id);
        course.setCourseName(newCourse.getCourseName());
        course.setTopic(newCourse.getTopic());
        course.setOwnerId(newCourse.getOwnerId());
        course.setOwner(userRepository.findUserById(newCourse.getOwnerId()));
        return courseRepository.save(course);
    }

    @GetMapping("/api/courses/{courseId}/{ownerId}")
    public Integer updateOwner(
            @PathVariable("courseId") Integer id,
            @PathVariable("ownerId") Integer ownerId) {
        courseRepository.updateOwner(id, ownerId);
        return 1;
    }

    @GetMapping("/api/courses/{courseId}/owner")
    public Integer findOwner(
            @PathVariable("courseId") Integer id) {
        return courseRepository.findOwner(id);
    }

    @GetMapping("/api/courses/{courseId}/delete")
    public Integer deleteCourse(
            @PathVariable("courseId") Integer id) {
        courseRepository.deleteById(id);
        return 1;
    }

    @GetMapping("/api/courses/{userId}/find")
    public User findUserById(
        @PathVariable("userId") Integer id) {
    return userRepository.findUserById(id);
    }

    @GetMapping("/api/courses/{courseId}/lessons")
    public List<Lesson> findCourseByOwner(
            @PathVariable("courseId") Integer userId) {
        return lessonRepository.findCourseLessons(userId);
    }

}
