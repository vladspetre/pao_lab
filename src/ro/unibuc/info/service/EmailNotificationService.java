package ro.unibuc.info.service;

import ro.unibuc.info.logging.ConsoleLogger;

public class EmailNotificationService implements NotificationService {

  public void sendGradeNotification()
  {
    ConsoleLogger.getInstance().logInfo("New Grade saved");
  }
}
