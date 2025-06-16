package org.aniverse;

public class Course {
  private static int nextId = 1;
  private final int id;
  private String name;

  public Course(String name) {
    id = nextId++;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Course name cannot be null or empty");
    }
    this.name = name;
  }

  @Override
  public String toString() {
    return "Course{" +
      "id=" + id +
      ", name='" + name + '\'' +
      '}';
  }
}
