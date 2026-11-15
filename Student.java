import java.util.ArrayList;
import java.util.Objects;

public class Student {
    private long idNum;
    private String firstName;
    private String lastName;
    private char gender;
    private String email;
    private ArrayList<Course> coursesRegistered;    private double GPA;
    private long advisorNum;

    public Student() {
        this(0, "", "", ' ', "", 0.0, 0); // this(...) must be the first line

        coursesRegistered = new ArrayList<>();
    }

    public Student(long idNum, String firstName, String lastName, char gender, String email, double GPA, long advisorNum) {
        this.idNum = idNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.coursesRegistered = new ArrayList<>();
        this.GPA = GPA;
        this.advisorNum = advisorNum;
    }

    public long getIdNum() {
        return idNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Course> getCoursesRegistered() {
        return coursesRegistered;
    }

    public double getGPA() {
        return GPA;
    }

    public long getAdvisorNum() {
        return advisorNum;
    }

    public void setIdNum(long idNum) {
        this.idNum = idNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCoursesRegistered(ArrayList<Course> coursesRegistered) {
        this.coursesRegistered = coursesRegistered;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setAdvisorNum(long advisorNum) {
        this.advisorNum = advisorNum;
    }

    public boolean equals(Student obj) {
        return (this.idNum == obj.idNum);
    }

    public void printCoursesRegistered() {
        if (coursesRegistered.size() == 0) {
            System.out.println("Registered courses are empty !");
            return;
        }

        System.out.println("The courses registered : ");

        int a = 0;
        for (Course course : coursesRegistered) {
            System.out.println("Course " + (a + 1));
            System.out.println("Course name : " + course.getCourseName());
            System.out.println("Course number : " + course.getCourseNum());
            System.out.println("Credits : " + course.getCredits());
            System.out.println("Section : " + course.getSection());
            System.out.println("--------------------------------------------");
            a++;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "idNum=" + idNum +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", GPA=" + GPA +
                ", advisorNum=" + advisorNum +
                '}';
    }
}
