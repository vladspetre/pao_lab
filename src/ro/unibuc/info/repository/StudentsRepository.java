package ro.unibuc.info.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ro.unibuc.info.config.DatabaseConnection;
import ro.unibuc.info.model.Student;

public class StudentsRepository {

  public static Student getStudentById(int id){
    String sql = "Select * from students where studentid = ?";

    try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql))
    {
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();

      while(resultSet.next())
      {
        return new Student(
            resultSet.getString("firstname"),
            resultSet.getString("lastname"),
            20,"",1,"","",1,""
        );
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

}
