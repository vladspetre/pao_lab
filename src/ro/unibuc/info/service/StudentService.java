package ro.unibuc.info.service;

import java.util.Arrays;
import java.util.List;
import ro.unibuc.info.model.Student;
import ro.unibuc.info.utils.FileUtils;

public class StudentService {

  public List<Student> loadStudentsFromFile() {
    String fileContent = FileUtils.readFromFile("resources/students.csv");
    String[] lines = fileContent.split("\n");

    return Arrays.stream(lines)
        .map(this::buildStudent)
        .toList();
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
    return student.getFirstName() + "," + student.getLastName() + "," + student.getEmail();
  }

  public String getStudentDetails(Student student) {
    return student.getFirstName() + "," + student.getLastName() + "," + student.getEmail();
  }
}
