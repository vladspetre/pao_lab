package ro.unibuc.info.model;

public class Student extends Person{

  private int studentId;
  private String school;
  private String specialization;
  private int year;
  private String email;

  public Student(String firstName, String lastName, int age, String socialNr, int studentId,
      String school, String specialization, int year,String email) {
    super(firstName, lastName, age, socialNr);
    this.studentId = studentId;
    this.school = school;
    this.specialization = specialization;
    this.year = year;
    this.email = email;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getSpecialization() {
    return specialization;
  }

  public void setSpecialization(String specialization) {
    this.specialization = specialization;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Student{");
    sb.append("studentId=").append(studentId);
    sb.append(", school='").append(school).append('\'');
    sb.append(", specialization='").append(specialization).append('\'');
    sb.append(", year=").append(year);
    sb.append(", email='").append(email).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
