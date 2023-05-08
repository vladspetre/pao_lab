package ro.unibuc.info.service;

public class EmailNotificationService implements NotificationService {

  @Override
  public void sendFreeNotification()
  {
    System.out.println("Email: New spot is free");
  }

  @Override
  public void sendBusyNotification()
  {
    System.out.println("Email: A spot became busy");
  }

}
