import java.util.*;

public class Roster {
    private LinkedList<Student> studentsList;
    private int size;

    public Roster() {
        studentsList = new LinkedList<>();
        size = 0;
    }

    public boolean addStudent(Student st) {
        int index = searchStudent(st.getIdNum());
        if (index != -1) {
            System.out.println("This student is already registered! ");
            return false;
        }

        else {
            // find where the new student goes so the list stays sorted by ID
            int i = 0, x = 0;
            while (i < size) {
                if (studentsList.get(i).getIdNum() < st.getIdNum())
                    x++;
                else break;

                i++;
            }

            studentsList.add(x, st);
            size++;
            System.out.println("Student " + st.getIdNum() + " is added successfully ");
            return true;
        }
    }

    public boolean deleteStudent(long idNum) {
        int index = searchStudent(idNum);
        if (index == -1) {
            System.out.println("Student with id " + idNum + " is not found ");
            return false;
        }
        studentsList.remove(index);
        size--;
        System.out.println("Student deleted successfully");
        return true;
    }

    public int searchStudent(long idNum) {
        for (int i = 0; i < size; i++)
            if ((studentsList.get(i).getIdNum()) == (idNum))
                return i;

        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int listSize() {
        return size;
    }

    public Student getStudent(int index) {
        if (index < 0 || index >= size) {
            System.out.println("This index is not valid!");
            throw new IndexOutOfBoundsException();
        }
        return studentsList.get(index);
    }

    public boolean addCourse(Course course, long idNum) {
        int index = searchStudent(idNum);
        if (index == -1) {
            return false;
        }

        else {
            Student student = studentsList.get(index);
            int s = studentsList.get(index).getCoursesRegistered().size();
            for (int i = 0; i < s; i++)
                if (student.getCoursesRegistered().get(i).getCourseNum().equalsIgnoreCase(course.getCourseNum())) {
                    System.out.println("The course is already registered before!");
                    return false;
                }

            int totalCredits = 0;
            for (int i = 0; i < s; i++) {
                int credits = student.getCoursesRegistered().get(i).getCredits();
                totalCredits = totalCredits + credits;
            }

            totalCredits += course.getCredits();

            // max 18 credits, or 21 if the GPA is above 3.00
            if ((totalCredits > 18 && (student.getGPA() <= 3.0) || (totalCredits > 21))) {
                System.out.println("can't add the course , the credits are exceeds! ");
                return false;
            }

            else {
                student.getCoursesRegistered().add(course);
                System.out.println(course.getCourseName() + course.getCourseNum() + " is added successfully ");
                return true;
            }
        }
    }

    public void deleteCourse(Course course, long idNum) {
        int index = searchStudent(idNum);
        if (index == -1) {
            System.out.println("Student with id " + idNum + " is not found ");
            return;
        }
        Student student = studentsList.get(index);

        if (student.getCoursesRegistered().isEmpty()) {
            System.out.println("The courses registered list is empty!");
            return;
        }

        int s = studentsList.get(index).getCoursesRegistered().size();

        int totalCredits = 0;
        int found = -1;
        for (int i = 0; i < s; i++) {
            int credits = student.getCoursesRegistered().get(i).getCredits();
            totalCredits = totalCredits + credits;
            if (student.getCoursesRegistered().get(i).getCourseNum().equalsIgnoreCase(course.getCourseNum()))
                found = i;
        }

        if (found == -1) {
            System.out.println("You has not registered this course before , it's not found!");
            return;
        }

        // use the credits of the registered course, not the ones passed in
        totalCredits = totalCredits - student.getCoursesRegistered().get(found).getCredits();

        if (totalCredits < 12) {
            System.out.println("Cannot delete course. Minimum 12 credit hours required.");
            return;
        }

        student.getCoursesRegistered().remove(found);
        System.out.println(course.getCourseNum() + " is deleted successfully ");
    }

    public void printStudentDetails(long idNum) {
        int index = searchStudent(idNum);
        if (index == -1) {
            System.out.println("Student is not found!");
            return;
        }

        Student student = studentsList.get(index);

        System.out.println(student);

        student.printCoursesRegistered();
    }

    public void printAdvisor(long idNum) {
        int index = searchStudent(idNum);
        if (index == -1) {
            System.out.println("Student is not found!");
            return;
        }

        Student student = studentsList.get(index);
        System.out.println("Advisor number: " + student.getAdvisorNum());
    }
}
