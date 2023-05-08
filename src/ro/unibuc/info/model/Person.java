package ro.unibuc.info.model;

public class Person {

  private String firstName;
  private String lastName;
  private int age;
  private String socialNr;

  public Person(String firstName, String lastName, int age, String socialNr) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.socialNr = socialNr;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSocialNr() {
    return socialNr;
  }

  public void setSocialNr(String socialNr) {
    this.socialNr = socialNr;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Person{");
    sb.append("firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", age=").append(age);
    sb.append(", socialNr='").append(socialNr).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
