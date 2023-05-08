package ro.unibuc.info.service;

import ro.unibuc.info.logging.ConsoleLogger;

public class SmsNotificationService implements NotificationService {

  @Override

  public void sendGradeNotification()
  {
    ConsoleLogger.getInstance().logInfo("New Grade saved");
  }



}
