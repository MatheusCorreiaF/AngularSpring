package br.com.redfield.crudspringcourse.controller;

import br.com.redfield.crudspringcourse.model.Course;
import br.com.redfield.crudspringcourse.repository.CourseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/v1/course")
public class CourseController {

    /*@Autowired*/
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
