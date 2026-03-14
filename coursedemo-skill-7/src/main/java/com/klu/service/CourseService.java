package com.klu.service;

import java.util.List;
import com.klu.model.Course;

public interface CourseService {

    Course addCourse(Course course);
    Course updateCourse(int id, Course course);
    boolean deleteCourse(int id);
    Course getCourseById(int id);
    List<Course> getAllCourses();
    List<Course> searchByTitle(String title);
}