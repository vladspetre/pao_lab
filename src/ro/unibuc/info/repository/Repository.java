package ro.unibuc.info.repository;

import java.util.List;
import java.util.Optional;
import ro.unibuc.info.model.Student;

public interface Repository {

  Optional<Student> getStudentById(int id);

  int insert(Student s);

  List<Student> findAll();

}
