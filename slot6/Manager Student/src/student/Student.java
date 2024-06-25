package student;

import java.util.List;
import validate.Validator;

public class Student implements Comparable<Student> {

    private String id;
    private String studentName;
    private String semester;
    private String courseName;

    /**
     * Default constructor for creating a Student object.
     */
    public Student() {
    }

    /**
     * Parameterized constructor for creating a Student object with specific
     * attributes.
     *
     * @param id The ID of the student.
     * @param studentName The name of the student.
     * @param semester The semester the student is enrolled in.
     * @param courseName The name of the course the student is taking.
     */
    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    /**
     * Get the ID of the student.
     *
     * @return The ID of the student.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of the student.
     *
     * @param id The ID to set for the student.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the name of the student.
     *
     * @return The name of the student.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Set the name of the student.
     *
     * @param studentName The name to set for the student.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Get the semester the student is enrolled in.
     *
     * @return The semester the student is enrolled in.
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Set the semester the student is enrolled in.
     *
     * @param semester The semester to set for the student.
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Get the name of the course the student is taking.
     *
     * @return The name of the course the student is taking.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Set the name of the course the student is taking.
     *
     * @param courseName The name of the course to set for the student.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * This method is used to compare two students by their names.
     *
     * @param t Another Student object to compare to.
     * @return It returns a positive, negative, or zero value indicating the
     * comparison result.
     */
    @Override
    public int compareTo(Student t) {
        return this.studentName.compareTo(t.studentName); //(giam dan theo ten thi them "-" vao truoc chu this)
    }

    /**
     * This method used to create a record of Student and add it to list
     *
     * @param students the List student to check valid ID Student,Name Student
     */
    public void input(List<Student> students) {
        boolean checkIDExisted = false;
        id = Validator.getString("Enter id:", "Invalid!",
                "[A-Za-z0-9\\s]+");
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(id)) {
                studentName = students.get(i).getStudentName();
                System.out.println("Name Student: " + students.get(i).getStudentName());
                checkIDExisted = true;
                break;
            }
        }
        if (!checkIDExisted) {
            studentName = Validator.getString("Enter Name:", "Invalid!",
                    "[A-Za-z\\s]+");
        }
        int chooseSemester = Validator.getInt("Only three semester:\n"
                + "\t1-Spring\n"
                + "\t2-Summer\n"
                + "\t3-Fall\n"
                + "Enter your choice:",
                "Please enter number 1->3", "Invalid", 1, 3);
        switch (chooseSemester) {
            case 1:
                semester = "Spring";
                break;
            case 2:
                semester = "Summer";
                break;
            case 3:
                semester = "Fall";
                break;
        }
        int year = Validator.getInt("Enter year Semerter: ",
                "Please enter year >= 2000", "Invalid!", 2000, 2050);
        semester = semester+year;
        int choose = Validator.getInt("Only three courses:\n"
                + "\t1-Java\n"
                + "\t2-.Net\n"
                + "\t3-C/C++\n"
                + "Enter your choice:",
                "Please enter number 1->3", "Invalid", 1, 3);
        switch (choose) {
            case 1:
                courseName = "Java";
                break;
            case 2:
                courseName = ".NET";
                break;
            case 3:
                courseName = "C/C++";
                break;
        }
    }
}
