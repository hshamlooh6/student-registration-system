import java.util.*;

public class Registration {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Roster roster = new Roster();
        Course course = new Course();
        Student student = new Student();

        Long id;

        int option = 0;

        System.out.println("Select a service number: ");
        System.out.println("1. Register student");
        System.out.println("2. Remove student");
        System.out.println("3. Add Course to Student");
        System.out.println("4. Remove Course from Student");
        System.out.println("5. Get student location in the list ");
        System.out.println("6. Print Student Advisor ");
        System.out.println("7. Print All Student Information");
        System.out.println("8. Get main information about student ");
        System.out.println("9. Get students list size ");
        System.out.println("10. Get All students based on ID ascending order ");
        System.out.println("11. Leave");

        while (option != 11) {
            System.out.println("Select a number: ");

            try {
                option = in.nextInt();
                if (option < 1 || option > 11) {
                    System.out.println("Invalid selection. Please enter a number between 1 and 11.");
                }

                else {
                    switch (option) {
                        case 1:
                            System.out.println("Enter the Student ID: ");
                            id = in.nextLong();

                            if (roster.searchStudent(id) == -1) {
                                System.out.println("Enter the First Name: ");
                                String firstName = in.next();
                                System.out.println("Enter the Last Name: ");
                                String lastName = in.next();
                                System.out.println("Enter the Gender (M/F): ");
                                char gender = in.next().charAt(0);
                                System.out.println("Enter the Email: ");
                                String email = in.next();
                                System.out.println("Enter the GPA: ");
                                double GPA = in.nextDouble();
                                System.out.println("Enter the AdvisorNum : ");
                                long advisorNum = in.nextLong();
                                student = new Student(id, firstName, lastName, gender, email, GPA, advisorNum);
                                roster.addStudent(student);
                            }

                            else System.out.println("Student with id " + id + " is already registered , re-select the service you want ");

                            break;

                        case 2:
                            System.out.println("Enter Student ID to delete: ");
                            long IdNum = in.nextLong();
                            roster.deleteStudent(IdNum);
                            break;

                        case 3:
                            System.out.println("Enter Student ID: ");
                            id = in.nextLong();

                            if (roster.searchStudent(id) != -1) {
                                System.out.println("Enter Course Number to add: ");
                                String courseNum = in.next();
                                System.out.println("Enter Course Name to add: ");
                                in.nextLine(); // skip the rest of the line before reading the full name
                                String courseName = in.nextLine();
                                System.out.println("Enter Course Credits: ");
                                int courseCredits = in.nextInt();
                                System.out.println("Enter Course Section: ");
                                int courseSection = in.nextInt();

                                Course c = new Course(courseNum, courseName, courseCredits, courseSection);

                                roster.addCourse(c, id);
                            }

                            else System.out.println("Student with id " + id + " is not found , re-select the service you want ");

                            break;

                        case 4:
                            System.out.println("Enter Student ID: ");
                            id = in.nextLong();
                            System.out.println("Enter Course Number to remove: ");
                            String courseNum1 = in.next();

                            // only the course number is needed to find the course
                            String courseName1 = course.getCourseName();
                            int courseCredits1 = course.getCredits();
                            int section = course.getSection();
                            Course c1 = new Course(courseNum1, courseName1, courseCredits1, section);

                            roster.deleteCourse(c1, id);
                            break;

                        case 5:
                            System.out.println("Enter student ID : ");
                            id = in.nextLong();
                            System.out.println("The student location is " + roster.searchStudent(id));
                            break;

                        case 6:
                            System.out.println("Enter Student ID : ");
                            id = in.nextLong();
                            roster.printAdvisor(id);
                            break;

                        case 7:
                            System.out.println("Enter Student ID : ");
                            id = in.nextLong();

                            roster.printStudentDetails(id);
                            break;

                        case 8:
                            System.out.println("Enter student index you want to retrieve: ");
                            int ind = in.nextInt();
                            student = roster.getStudent(ind);

                            if (student == null) System.out.println("No student available here");
                            else System.out.println(student);
                            break;

                        case 9:
                            if (roster.isEmpty()) System.out.println("the list is empty!");
                            else System.out.println("The list size : " + roster.listSize());
                            break;

                        case 10:
                            if (roster.isEmpty())
                                System.out.println("No students available in the list .");
                            else {
                                System.out.println("All students:");
                                for (int i = 0; i < roster.listSize(); i++) {
                                    Student st = roster.getStudent(i);
                                    System.out.println(st.getFirstName() + " " + st.getLastName() + " " + st.getIdNum());
                                }
                            }
                            break;

                        case 11:
                            System.out.println("Leaving...");
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Invalid selection. Please enter a number between 1 and 11.");
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input!");
                in.nextLine(); // skip the bad input so the menu keeps working
            }
        }
    }
}
