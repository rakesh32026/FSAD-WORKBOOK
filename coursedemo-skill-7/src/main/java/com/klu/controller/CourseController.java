package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // CREATE
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        if (course.getTitle() == null || course.getTitle().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Course title cannot be empty");
        }

        Course saved = service.addCourse(course);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        Course course = service.getCourseById(id);
        if (course == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Course not found");
        }
        return ResponseEntity.ok(course);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,
                                          @RequestBody Course course) {

        Course updated = service.updateCourse(id, course);
        if (updated == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Course not found for update");
        }
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {

        boolean deleted = service.deleteCourse(id);
        if (!deleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Course not found for deletion");
        }
        return ResponseEntity.ok("Course deleted successfully");
    }

    // SEARCH
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchByTitle(@PathVariable String title) {
        return ResponseEntity.ok(service.searchByTitle(title));
    }
}