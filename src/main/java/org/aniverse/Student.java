package org.aniverse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
  private static int nextId = 1;
  private int id;
  private String name;
  private String surname;
  private String email;
  private final Set<Course> enrolledCourses = new HashSet<>();

  public Student(String name, String surname) {
    setId();
    setName(name);
    setSurname(surname);
    setEmail();
  }

  public void setId() {
    id = nextId++;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  private void setName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  private void setSurname(String surname) {
    if (surname == null || surname.isEmpty()) {
      throw new IllegalArgumentException("Surname cannot be null or empty");
    }
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  private void setEmail() {
    this.email = getName().toLowerCase() + "." + getSurname().toLowerCase() + "@school.edu.az";
  }

  public Set<Course> getCourses() {
    return enrolledCourses;
  }

  public void enrollCourse(Course... course) {
    enrolledCourses.addAll(Arrays.asList(course));
  }

  @Override
  public String toString() {
    return "Student{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", surname='" + surname + '\'' +
      ", email='" + email + '\'' +
      ", courses=" + enrolledCourses +
      "}";
  }
}
