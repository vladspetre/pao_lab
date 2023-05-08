package ro.unibuc.info.model;

import java.util.Objects;

public class Vehicle {

  private String id;
  private String chargingType;
  private double timeToFull;

  public Vehicle(String id, String chargingType, double timeToFull) {
    this.id = id;
    this.chargingType = chargingType;
    this.timeToFull = timeToFull;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getChargingType() {
    return chargingType;
  }

  public void setChargingType(String chargingType) {
    this.chargingType = chargingType;
  }

  public double getTimeToFull() {
    return timeToFull;
  }

  public void setTimeToFull(double timeToFull) {
    this.timeToFull = timeToFull;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Vehicle{");
    sb.append("id='").append(id).append('\'');
    sb.append(", chargingType='").append(chargingType).append('\'');
    sb.append(", timeToFull=").append(timeToFull);
    sb.append('}');
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return Double.compare(vehicle.timeToFull, timeToFull) == 0 && id.equals(vehicle.id)
        && chargingType.equals(vehicle.chargingType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, chargingType, timeToFull);
  }
}
