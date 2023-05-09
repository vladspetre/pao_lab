package ro.unibuc.info.service;

import ro.unibuc.info.logging.ConsoleLogger;
import ro.unibuc.info.logging.Logger;
import ro.unibuc.info.logging.LoggerFactory;
import ro.unibuc.info.logging.LoggerType;

public class SmsNotificationService implements NotificationService {
  final Logger logger = LoggerFactory.getLogger(LoggerType.CONSOLE);

  @Override

  public void sendGradeNotification()
  {
    logger.logInfo("New Grade saved");
  }



}
