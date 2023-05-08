package ro.unibuc.info.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger implements Logger{

  public static final String LOG_TEMPLATE = "%s, [%s] %s";
  private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @Override
  public void logInfo(String message) {
    System.out.println(String.format(LOG_TEMPLATE, LocalDateTime.now().format(fmt), "INFO", message));
  }

  @Override
  public void logError(String message) {
    System.err.println(String.format(LOG_TEMPLATE, LocalDateTime.now().format(fmt), "ERROR", message));
  }
}
