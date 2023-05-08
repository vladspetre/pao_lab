package ro.unibuc.info.model;

import java.util.List;

public class CourseGrades {

  private Course course;
  private List<Integer> grades;

  public CourseGrades(Course course, List<Integer> grades) {
    this.course = course;
    this.grades = grades;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public List<Integer> getGrades() {
    return grades;
  }

  public void setGrades(List<Integer> grades) {
    this.grades = grades;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CourseGrades{");
    sb.append("course=").append(course);
    sb.append(", grades=").append(grades);
    sb.append('}');
    return sb.toString();
  }
}
