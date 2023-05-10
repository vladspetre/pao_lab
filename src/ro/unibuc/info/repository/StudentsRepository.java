package ro.unibuc.info.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ro.unibuc.info.config.DatabaseConnection;
import ro.unibuc.info.logging.Logger;
import ro.unibuc.info.logging.LoggerFactory;
import ro.unibuc.info.logging.LoggerType;
import ro.unibuc.info.model.Student;

public class StudentsRepository implements Repository {

  Logger logger = LoggerFactory.getLogger(LoggerType.CONSOLE);

  @Override
  public Optional<Student> getStudentById(int id) {
    String sql = "Select * from students where studentid = ?";

    try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        return Optional.of(new Student(
            resultSet.getString("firstname"),
            resultSet.getString("lastname"),
            resultSet.getInt("age"),
            resultSet.getString("socialnr"),
            resultSet.getInt("studentid"),
            resultSet.getString("school"),
            resultSet.getString("specialization"),
            resultSet.getInt("year"),
            resultSet.getString("email")
        ));
      }
      return Optional.empty();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int insert(Student s) {
    String sql =
        "insert into students (firstname, lastname, age, socialnr, school, specialization, \"year\", email)"
            + "values(?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
      statement.setString(1, s.getFirstName());
      statement.setString(2, s.getLastName());
      statement.setInt(3, s.getAge());
      statement.setString(4, s.getSocialNr());
      statement.setString(5, s.getSchool());
      statement.setString(6, s.getSpecialization());
      statement.setInt(7, s.getYear());
      statement.setString(8, s.getEmail());

      return statement.executeUpdate();
    } catch (SQLException ex) {
      logger.logWarn(ex.getMessage());
      throw new RuntimeException(ex);
    }
}

  @Override
  public List<Student> findAll() {
    String sql = "Select * from students";

    List<Student> students = new ArrayList<>();

    try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        students.add(new Student(
            resultSet.getString("firstname"),
            resultSet.getString("lastname"),
            resultSet.getInt("age"),
            resultSet.getString("socialnr"),
            resultSet.getInt("studentid"),
            resultSet.getString("school"),
            resultSet.getString("specialization"),
            resultSet.getInt("year"),
            resultSet.getString("email")
        ));
      }
      return students;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


}
