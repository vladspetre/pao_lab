package ro.unibuc.info;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ro.unibuc.info.lambda.Function;
import ro.unibuc.info.model.ElectricCar;
import ro.unibuc.info.model.ElectricScooter;
import ro.unibuc.info.model.Vehicle;
import ro.unibuc.info.threads.ConsumerTask;
import ro.unibuc.info.threads.PrintNumbersRunnable;
import ro.unibuc.info.threads.ProducerTask;

public class Main {

  public static List<Integer> numbers = new ArrayList<>();
  public static void main(String[] args) {

    System.out.println(Thread.currentThread().getName() + " start thread");

    //v1
//    PrintNumbersThread t = new PrintNumbersThread();
//    t.start();

    //v2
//    Thread t = new Thread(() -> {
//      System.out.println(Thread.currentThread().getName() + "Starting printing numbers");
//      for (int i = 0; i < 10; i++) {
//        System.out.println(Thread.currentThread().getName() + " " + i);
//      }
//    }
//    );
//    t.start();

    //v3
//    ExecutorService es = Executors.newCachedThreadPool();
//
//    es.submit(() -> {
//      System.out.println(Thread.currentThread().getName() + "Starting printing numbers");
//      for (int i = 0; i < 10; i++) {
//        System.out.println(Thread.currentThread().getName() + " " + i);
//      }
//    });
//
//    es.submit(() -> {
//      System.out.println(Thread.currentThread().getName() + "Starting printing numbers");
//      for (int i = 0; i < 10; i++) {
//        System.out.println(Thread.currentThread().getName() + " " + i);
//      }
//    });


    //v4
    ExecutorService es = Executors.newCachedThreadPool();
    es.submit(new ProducerTask());
    es.submit(new ConsumerTask());
    es.submit(new ProducerTask());
    es.submit(new ConsumerTask());

    System.out.println(Thread.currentThread().getName() + " finish thread");

/*
    Logger consoleLog = new ConsoleLogger();
    Logger fileLog = new FileLogger();

    consoleLog.logInfo("This is an info msg");
    consoleLog.logError("This si error, it did boom");

    fileLog.logInfo("This is an info msg");
    fileLog.logError("This si error, it did boom");

    LogUtil.showLogsFromFile(consoleLog, FileLogger.LOG_FILE_PATH);

    File f = new File("test.txt");
    BufferedWriter writer = null;
    BufferedReader reader = null;
    try {
      if (!f.exists()) {
        System.out.println("create file");
        f.createNewFile();

        writer = new BufferedWriter(new FileWriter(f));
        writer.write("my \ndefault \ntext");
        writer.flush();
      }

      reader = new BufferedReader(new FileReader(f));
      String line = "";
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      // close resources
      try {
        reader.close();
        writer.close();
      } catch (Exception e) {
        // do nothing - log exception
        System.out.println("logged exception" + e.getMessage());
      }
    }

    System.out.println("1");
    try {
      // do something
      throwException();
    } catch (ArrayIndexOutOfBoundsException e) {
      //treat exception
      System.out.println("ArrayIndexOutOfBoundsException");
    } catch (ArithmeticException e) {
      //treat exception
      System.out.println("Aritmethic");
    } catch (Exception e) {
      //treat exception
      System.out.println("Exc");
    } finally {
      // executes every time
      System.out.println("finally");
    }

    System.out.println("2");

    NotificationService notificationService = new EmailNotificationService();
    ParkingService service = new ParkingService(notificationService);
//    ParkingService serviceSms = new ParkingService(new SmsNotificationService());

    ParkingLot pl = new ParkingLot("Lot1", 0, new ArrayList<>());

    Vehicle v1 = new ElectricCar("abcd", "Fast", 30);
    Vehicle v2 = new ElectricScooter("xyz", "SuperFast", 30);

    service.addVehicle(pl.getPumps(), v1);
    service.addVehicle(pl.getPumps(), v2);
    System.out.println(pl);

    //vehicle-type|charge-type|timetoFull

    String option = "";
    Scanner sc = new Scanner(System.in);
    do {
      if (option.equalsIgnoreCase("exit")) {
        return;
      }

      System.out.println("Please insert values as vehicle-type|charge-type|timetoFull");
      option = sc.nextLine();
      service.addVehicle(pl.getPumps(), buildVehicle(option));
      service.showLot(pl);
    } while (true);
*/
  }

  private static void throwException() {
    throw new RuntimeException("err msg");
  }

  private static void test(Function f) {
    System.out.println(f.apply(10, 10));
  }

  private static Function getFunction() {
    return (int a, int b) -> a * b;
  }

  private static Vehicle buildVehicle(String option) {
    String[] split = option.split("/");
    String vehicleType = split[0];
    String chargeType = split[1];
    Integer timeToFull = Integer.parseInt(split[2]);

    return getVehicleByType(vehicleType, chargeType, timeToFull);
  }

  private static Vehicle getVehicleByType(String vehicleType, String chargeType,
      Integer timeToFull) {
    switch (vehicleType) {
      case "car":
        return new ElectricCar("xxx", chargeType, timeToFull);
      case "scooter":
        return new ElectricScooter("xxx", chargeType, timeToFull);
      default:
        throw new RuntimeException("Invalid vehicle type");
    }
  }
}
