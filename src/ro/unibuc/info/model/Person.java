package ro.unibuc.info.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {
  private String firstName;
  private String lastName;
  private int age;
  private String socialNr;
}
