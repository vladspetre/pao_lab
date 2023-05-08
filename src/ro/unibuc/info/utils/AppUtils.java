package ro.unibuc.info.utils;

import ro.unibuc.info.logging.Logger;
import ro.unibuc.info.logging.LoggerFactory;
import ro.unibuc.info.logging.LoggerType;

public final class AppUtils {

  private AppUtils() {
  }

  public static void showMenu()
  {
    Logger logger = LoggerFactory.getLogger(LoggerType.CONSOLE);

    logger.logInfo("Please select and option");
    logger.logInfo("show -> show students list");
    logger.logInfo("details -> show student details");
    logger.logInfo("add grade -> Add student grade");
    logger.logInfo("exit -> Exit");
  }
}
