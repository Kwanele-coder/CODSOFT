import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean registerStudent() {
        if (enrolledStudents < capacity) {
            enrolledStudents++;
            return true;
        } else {
            System.out.println("Course is full. Cannot register.");
            return false;
        }
    }

    public void removeStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
            System.out.println("Student removed from the course.");
        } else {
            System.out.println("No students to remove from the course.");
        }
    }
}

class Student {
    private int studentID;
    private String name;
    private ArrayList<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerForCourse(Course course) {
        if (course.registerStudent()) {
            registeredCourses.add(course);
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration failed.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.removeStudent();
        } else {
            System.out.println("You are not registered for this course.");
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        // Create some courses
        Course course1 = new Course("CSE101", "Introduction to Programming", "Fundamentals of programming", 30, "Mon/Wed/Fri 10:00 AM");
        Course course2 = new Course("MAT202", "Calculus II", "Advanced calculus topics", 25, "Tue/Thu 2:00 PM");

        // Create some students
        Student student1 = new Student(1001, "John Doe");
        Student student2 = new Student(1002, "Jane Smith");

        // Display course listings
        displayCourseListing(course1);
        displayCourseListing(course2);

        // Student registration
        student1.registerForCourse(course1);
        student2.registerForCourse(course1);
        student2.registerForCourse(course2);

        // Display updated course listings
        displayCourseListing(course1);
        displayCourseListing(course2);

        // Student dropping a course
        student2.dropCourse(course1);

        // Display final course listings and student registrations
        displayCourseListing(course1);
        displayCourseListing(course2);
        displayStudentRegistrations(student1);
        displayStudentRegistrations(student2);
    }

    private static void displayCourseListing(Course course) {
        System.out.println("Course Code: " + course.getCourseCode());
        System.out.println("Title: " + course.getTitle());
        System.out.println("Description: " + course.getDescription());
        System.out.println("Capacity: " + course.getEnrolledStudents() + "/" + course.getCapacity());
        System.out.println("Schedule: " + course.getSchedule());
        System.out.println("----------------------------");
    }

    private static void displayStudentRegistrations(Student student) {
        System.out.println("Student ID: " + student.getStudentID());
        System.out.println("Name: " + student.getName());
        System.out.println("Registered Courses:");

        for (Course course : student.getRegisteredCourses()) {
            System.out.println(course.getTitle() + " (" + course.getCourseCode() + ")");
        }

        System.out.println("----------------------------");
    }
}
