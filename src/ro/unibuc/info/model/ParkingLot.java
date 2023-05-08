package ro.unibuc.info.model;

import java.util.Arrays;
import java.util.List;

public class ParkingLot {

  private String name;
  private int nrOfBusyPumps;

  private List<Pump> pumps;

  public ParkingLot(String name, int nrOfPumps, List<Pump> pumps) {
    this.name = name;
    this.nrOfBusyPumps = nrOfPumps;
    this.pumps = pumps;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNrOfBusyPumps() {
    return nrOfBusyPumps;
  }

  public void setNrOfBusyPumps(int nrOfBusyPumps) {
    this.nrOfBusyPumps = nrOfBusyPumps;
  }

  public List<Pump> getPumps() {
    return pumps;
  }

  public void setPumps(List<Pump> pumps) {
    this.pumps = pumps;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ParkingLot{");
    sb.append("name='").append(name).append('\'');
    sb.append(", nrOfPumps=").append(nrOfBusyPumps);
    sb.append(", pumps").append(pumps);
    sb.append('}');
    return sb.toString();
  }
}
