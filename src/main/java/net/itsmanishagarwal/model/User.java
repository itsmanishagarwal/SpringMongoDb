package net.itsmanishagarwal.model;

/**
 * @author manish
 */
public class User {

  public User(String name, Long age) {
    this.name = name;
    this.age = age;
  }
  private String name;

  private Long age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getAge() {
    return age;
  }

  public void setAge(Long age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User [name=" + name + ", age=" + age + "]";
  }
}
