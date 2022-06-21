package br.com.redfield.crudspringcourse;

import br.com.redfield.crudspringcourse.model.Course;
import br.com.redfield.crudspringcourse.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudspringcourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudspringcourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabaseDev(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course course = new Course();
			course.setName("Angular");
			course.setCategory("frontend");
			courseRepository.save(course);

			Course course2 = new Course();
			course2.setName("Spring");
			course2.setCategory("backend");
			courseRepository.save(course2);
		};
	}

}
