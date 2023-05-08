package ro.unibuc.info.model;

public class Pump {

  private int id;

  private Vehicle vehicle;

  public Pump() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isInUse() {
    return vehicle != null;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Pump{");
    sb.append("id=").append(id);
    sb.append(", vehicle=").append(vehicle);
    sb.append('}');
    return sb.toString();
  }
}
