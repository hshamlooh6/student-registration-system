import java.util.*;

public class Course {
    private String courseNum;
    private String courseName;
    private int credits;
    private int section;

    public Course() {
        this.courseNum = "";
        this.courseName = "";
        this.credits = 0;
        this.section = 0;
    }

    public Course(String courseNum, String courseName, int credits, int section) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.credits = credits;
        this.section = section;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public int getSection() {
        return section;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public boolean equals(Course obj) {
        return this.courseNum.equalsIgnoreCase(obj.courseNum);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseNum='" + courseNum + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", section=" + section +
                '}';
    }
}
