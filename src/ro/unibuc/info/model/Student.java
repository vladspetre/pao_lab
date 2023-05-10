package ro.unibuc.info.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Student extends Person {

  private int studentId;
  private String school;
  private String specialization;
  private int year;
  private String email;

  public Student(String firstName, String lastName, int age, String socialNr, int studentId,
      String school, String specialization, int year, String email) {
    super(firstName, lastName, age, socialNr);
    this.studentId = studentId;
    this.school = school;
    this.specialization = specialization;
    this.year = year;
    this.email = email;
  }

}
