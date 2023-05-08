package ro.unibuc.info;

import java.util.List;
import java.util.Scanner;
import ro.unibuc.info.logging.Logger;
import ro.unibuc.info.logging.LoggerFactory;
import ro.unibuc.info.logging.LoggerType;
import ro.unibuc.info.model.Student;
import ro.unibuc.info.service.StudentService;
import ro.unibuc.info.utils.AppUtils;

public class Main {

  public static void main(String[] args) {

    final Logger logger = LoggerFactory.getLogger(LoggerType.CONSOLE);

    StudentService studentService = new StudentService();

    // load students from file
    List<Student> students = studentService.loadStudentsFromFile();

    //TODO: load data from file
    // show menu for catalog - get all students, get student details, get student grades, get student final grade etc
    // filter students, use streams

    Scanner scanner = new Scanner(System.in);
    String option = "";

    do {
      AppUtils.showMenu();
      option = scanner.nextLine();

      switch (option){
        case "show":
          //show students list
          break;

        case "details":
          // show student details by  stundentid or name - stream.filter, optional
          break;
        case "add grade":
            // add grade by course
          break;
        case "exit":
          logger.logInfo("Thank you, bye!");
          option = "";
          break;
        default:
          logger.logWarn("Invalid option selected, please try again!");
      }
    }while(!"".equals(option));

  }

}
