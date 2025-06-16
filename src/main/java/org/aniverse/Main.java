package org.aniverse;

import java.io.FileWriter;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    var list = getStudents();

    try (FileWriter writer = new FileWriter("./src/main/resources/Students.csv")) {
      writer.append("ID,Name,Surname,Email,Enrolled Courses\n");
      list
        .forEach((student) -> {
          try {
            String row = student.getId() +
              "," +
              escapeCsv(student.getName()) +
              "," +
              escapeCsv(student.getSurname()) +
              "," +
              escapeCsv(student.getEmail()) +
              "," +
              escapeCsv(student.getCourses().stream()
                .map(Course::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("No courses")) +
              "\n";
            writer.append(row);
          } catch (Exception ex) {
            System.err.println(ex.getMessage());
          }
        });
    } catch (Exception ex) {
      System.err.println("Error writing to file: " + ex.getMessage());
    }

    System.out.println("Students: " + list);
  }

  private static List<Student> getStudents() {
    var math = new Course("Mathematics");
    var physics = new Course("Physics");
    var chemistry = new Course("Chemistry");

    var student1 = new Student("Alice", "Smith");
    student1.enrollCourse(math);
    student1.enrollCourse(physics);
    var student2 = new Student("Bob", "Johnson");
    student2.enrollCourse(chemistry);
    var student3 = new Student("Charlie", "Brown");
    student3.enrollCourse(math);
    var student4 = new Student("David", "Williams");
    student4.enrollCourse(physics);
    var student5 = new Student("Eve", "Jones");
    student5.enrollCourse(chemistry);
    student5.enrollCourse(math);
    student5.enrollCourse(physics);

    return List.of(student1, student2, student3, student4, student5);
  }

  private static String escapeCsv(String value) {
    if (value == null) {
      return "";
    }
    // Enclose in quotes if the value contains commas, quotes, or newlines
    if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
      return "\"" + value.replace("\"", "\"\"") + "\"";
    }
    return value;
  }
}