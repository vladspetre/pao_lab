package ro.unibuc.info.service;

import java.util.List;
import ro.unibuc.info.model.ParkingLot;
import ro.unibuc.info.model.Pump;
import ro.unibuc.info.model.Vehicle;

public class ParkingService {

  private final NotificationService notificationService;

  public ParkingService(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  public void addVehicle(List<Pump> pumps, Vehicle v) {
    for (Pump pump : pumps) {
      if (pump.getVehicle() == null) {
        pump.setVehicle(v);
        notificationService.sendBusyNotification();
        break;
      }
      System.out.println("Parking lot is full");

    }
  }

  public void removeVehicle(Pump[] pumps, Vehicle v) {
    for (int i = 0; i < pumps.length; i++) {
      if (pumps[i] != null && pumps[i].getVehicle().equals(v)) {
        pumps[i].setVehicle(null);
        notificationService.sendFreeNotification();
        break;
      }
    }
  }

  public void showLot(ParkingLot lot)
  {
    for (Pump pump : lot.getPumps()) {
      System.out.println(pump);
    }
  }


}
