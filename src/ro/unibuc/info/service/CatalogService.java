package ro.unibuc.info.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ro.unibuc.info.model.Catalog;
import ro.unibuc.info.model.Course;
import ro.unibuc.info.model.CourseGrades;
import ro.unibuc.info.model.Student;

public class CatalogService {

  public Catalog init(List<Student> students){
    Map<Student, List<CourseGrades>> studentsGrades = new HashMap<>();
    students.forEach(student -> {
      List<CourseGrades> grades = Arrays.stream(Course.values())
          .map(course -> new CourseGrades(course, new ArrayList<>())).collect(
              Collectors.toList());

      studentsGrades.put(student, grades);
    });

    return new Catalog(2, studentsGrades);
  }
}
