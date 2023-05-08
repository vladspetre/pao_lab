package ro.unibuc.info.model;

public class ElectricCar extends Vehicle{

  public ElectricCar(String id, String chargingType, double timeToFull) {
    super(id, chargingType, timeToFull);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ElectricCar{");
    sb.append("id='").append(getId()).append('\'');
    sb.append(", chargingType='").append(getChargingType()).append('\'');
    sb.append(", timeToFull=").append(getTimeToFull());
    sb.append('}');
    return sb.toString();
  }
}
