package ro.unibuc.info.model;

import java.util.List;
import java.util.Map;

public class Catalog {

  private int year;
  private Map<Student, List<CourseGrades>> grades;

  public Catalog(int year, Map<Student, List<CourseGrades>> grades) {
    this.year = year;
    this.grades = grades;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public Map<Student, List<CourseGrades>> getGrades() {
    return grades;
  }

  public void setGrades(Map<Student, List<CourseGrades>> grades) {
    this.grades = grades;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Catalog{");
    sb.append("year=").append(year);
    sb.append(", grades=").append(grades);
    sb.append('}');
    return sb.toString();
  }
}
