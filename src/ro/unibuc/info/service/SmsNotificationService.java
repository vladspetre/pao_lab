package ro.unibuc.info.service;

public class SmsNotificationService implements NotificationService {

  @Override

  public void sendFreeNotification()
  {
    System.out.println("SMS: New spot is free");
  }

  @Override
  public void sendBusyNotification()
  {
    System.out.println("SMS: A spot became busy");
  }

}
