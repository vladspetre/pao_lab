package ro.unibuc.info;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import ro.unibuc.info.logging.Logger;
import ro.unibuc.info.logging.LoggerFactory;
import ro.unibuc.info.logging.LoggerType;
import ro.unibuc.info.model.Catalog;
import ro.unibuc.info.model.Course;
import ro.unibuc.info.model.Student;
import ro.unibuc.info.repository.StudentsRepository;
import ro.unibuc.info.service.CatalogService;
import ro.unibuc.info.service.StudentService;
import ro.unibuc.info.utils.AppUtils;

public class Main {

  public static void main(String[] args) {
    final Logger logger = LoggerFactory.getLogger(LoggerType.CONSOLE);

    StudentService studentService = new StudentService(); //dependency injection for repository
    CatalogService catalogService = new CatalogService();

    // load students from file
    List<Student> students = studentService.loadStudentsFromFile();
    Catalog catalog = catalogService.init(students);
    //TODO: load data from file
    // show menu for catalog - get all students, get student details, get student grades, get student final grade etc
    // filter students, use streams

    //TODO: refactor this
    Student s = StudentsRepository.getStudentById(1);
    logger.logInfo(s.getFirstName() + " " + s.getLastName());

    Scanner scanner = new Scanner(System.in);
    String option = "";

    do {
      AppUtils.showMenu();
      option = scanner.nextLine();

      switch (option) {
        case "show" -> students.stream()
            .sorted(Comparator.comparing(Student::getLastName))
            .map(studentService::getStudentHeader)
            .forEach(logger::logInfo);
        case "details" -> {
          logger.logInfo("Type student's last name");
          String key = scanner.nextLine();
          students.stream()
              .filter(student -> student.getLastName().equalsIgnoreCase(key))
              .map(student -> studentService.getStudentDetails(student, catalog))
              .forEach(logger::logInfo);
        }
        case "add grade" -> {
          logger.logInfo("Type student's details: email/materie/nota");
          String[] gradeDetails = scanner.nextLine().split("/");

          catalog.getGrades().forEach((key1, value) -> {
            if (key1.getEmail().equalsIgnoreCase(gradeDetails[0])) {
              value.stream()
                  .filter(courseGrades -> courseGrades.getCourse()
                      .equals(Course.valueOf(gradeDetails[1])))
                  .findFirst()
                  .ifPresent(courseGrades -> courseGrades.getGrades()
                      .add(Integer.valueOf(gradeDetails[2])));
            }
          });
        }
        case "exit" -> {
          logger.logInfo("Thank you, bye!");
          option = "";
        }
        default -> logger.logWarn("Invalid option selected, please try again!");
      }
    } while (!"".equals(option));

  }


}
