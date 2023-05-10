package ro.unibuc.info.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import lombok.RequiredArgsConstructor;
import ro.unibuc.info.exception.DataNotFoundException;
import ro.unibuc.info.model.Catalog;
import ro.unibuc.info.model.Student;
import ro.unibuc.info.repository.Repository;
import ro.unibuc.info.utils.FileUtils;

@RequiredArgsConstructor
public class StudentService {

  private final Repository studentsRepository;

  public Student getStudentById(int id) {
    return studentsRepository.getStudentById(id)
        .orElseThrow(()-> new DataNotFoundException("Could not find user with id " + id));
  }

  public List<Student> loadStudentsFromFile() {
    String fileContent = FileUtils.readFromFile("resources/students.csv");
    String[] lines = fileContent.split("\n");

    return Arrays.stream(lines)
        .map(this::buildStudent)
        .toList();
  }

  public void insert(List<Student> students) {
    students.forEach(studentsRepository::insert);
  }

  public List<Student> findAll() {
    return studentsRepository.findAll();
  }

  private Student buildStudent(String line) {
    String[] details = line.split(",");
    return new Student(
        details[0],
        details[1],
        Integer.parseInt(details[2]),
        details[3],
        Integer.parseInt(details[4]),
        details[5],
        details[6],
        Integer.parseInt(details[7]),
        details[8]
    );
  }

  public String getStudentHeader(Student student) {
    return "%s,%s,%s".formatted(student.getFirstName(), student.getLastName(), student.getEmail());
  }

  public String getStudentDetails(Student student, Catalog catalog) {

    StringBuilder sb = new StringBuilder().append(student.getFirstName()).append(",")
        .append(student.getLastName()).append(",")
        .append(student.getEmail()).append(",")
        .append("Grades:");

    catalog.getGrades().entrySet().stream()
        .filter(entry -> entry.getKey().getLastName().equals(student.getLastName()))
        .findFirst()
        .map(Entry::getValue)
        .ifPresent(sb::append);

    return sb.toString();
  }
}
