package management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import student.Student;
import validate.Validator;

public class Management {

    /**
     * @param args the command line arguments
     */
    ArrayList<Student> students = new ArrayList<>();

    /**
     * This method used to check record Student existed in list student or not .
     * 
     * @param id the id of student
     * @param name the name of student
     * @param semester the semester of student
     * @param courseName the course name of student
     * @return return true if student existed ,otherwise return false 
     */
    public boolean checkRecordStudentExist(String id, String name,
            String semester, String courseName) {
        for (Student student : students) {
            if (id.equals(student.getId())
                    && semester.equals(student.getSemester())
                    && name.equals(student.getStudentName())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method used to create a record of Student and add it to list
     */
    public void createStudent() {
        while (true) {
            String choice;
            if (students.size() > 10) {
                choice = Validator.getString("Do you want to order now (Y/N)?",
                        "Just (Y or N) ", "^[YNyn]$");
                if (choice.equalsIgnoreCase("N")) {
                    return;
                }
            }
            Student newStudent = new Student();
            newStudent.input(students);
            if (!checkRecordStudentExist(newStudent.getId(), newStudent.getStudentName(), 
                    newStudent.getSemester(), newStudent.getCourseName())) {
                students.add(newStudent);
                System.out.println("Creating susscess!");
            } else {
                System.out.println("This record is existed.Create fail!");
            }
        }
    }
    
    /**
     * This method used to sort list by name descending and 
     * search student by name then 
     * print information if find success on the screen 
     */
    public void findAndSort() {
        String name = Validator.getString("Enter Name:", "Invalid!",
                "[A-Za-z\\s]+");
        ArrayList<Student> result = new ArrayList<>();
        
        if (students.isEmpty()) {
            System.out.println("No students");
            return;
        }
        int count = 0;
        for (Student student : students) {
            if (student.getStudentName().toLowerCase().
                    contains(name.toLowerCase())) {
                result.add(student);
                count++;
            }
        }
        if (count > 0) {
            /*Collection.sort used method compareTo in Student class 
        to sort Student by name*/
        Collections.sort(result);
            System.out.println("+-----+---------------+----------+"
                    + "---------------+");
            System.out.printf("|%5s|%15s|%10s|%15s|\n", "No.", "Student Name",
                    "Semester", "Course Name");
            System.out.println("+-----+---------------+----------+"
                    + "---------------+");
            for (int i = 0; i < result.size(); i++) {
                System.out.printf("|%5s|%15s|%10s|%15s|\n", i + 1, 
                        result.get(i).getStudentName(),
                        result.get(i).getSemester(), 
                        result.get(i).getCourseName());
            }
            System.out.println("+-----+---------------+----------+-"
                    + "---------------+");
        } else {
            System.out.println("Not found!");
        }
    }
    
    /**
     * This method used to update or delete student by id
     */
    public void updateOrDelete() {
        String id = Validator.getString("Enter id:",
                "Invalid!", "[A-Za-z0-9\\s]+");
        ArrayList<Student> listStudentFindByID = getListStudentById(id);
        if (listStudentFindByID.isEmpty()) {
            System.out.println("Not found student.");
        } else {
            Student student = getStudentRecordByListFound(listStudentFindByID);
            String choice = Validator.getString("(Do you want to update (U)"
                    + " or delete (D):",
                    "Just(U or D)", "^[UuDd]$"); //^ va $ la dac trung cua regex(ranh gioi bat dau/ket thuc)
            //check choice = U will update , if choice = D will delete
            if (choice.equalsIgnoreCase("u")) {
                String newSemester = Validator.getString("Enter New semester:",
                        "Invalid!", "[A-Za-z0-9\\s]+");
                String newCourse = "";
                int choose = Validator.getInt("Only three courses:\n"
                        + "\t1-Java\n"
                        + "\t2-.NET\n"
                        + "\t3-C/C++\n"
                        + "Enter your new choice:",
                        "Please enter number 1->3", "Invalid", 1, 3);
                //user will input course by select menu (1,2 and 3)
                switch (choose) {
                    case 1:
                        newCourse = "Java";
                        break;
                    case 2:
                        newCourse = ".NET";
                        break;
                    case 3:
                        newCourse = "C/C++";
                        break;
                }
                if(checkRecordStudentExist(id,student.getStudentName(),
                        newSemester,newCourse)){
                    System.out.println("Update fail!"
                            + "Because Two record same after update!");
                    return;
                }
                for (int i = 0; i < students.size(); i++) {
                    if (student.equals(students.get(i))) {
                        students.get(i).setSemester(newSemester);
                        students.get(i).setCourseName(newCourse);
                    }
                }
                System.out.println("Update sucess!");
            } else {
                students.remove(student);
                System.out.println("Delete success!");
            }
        }
    }
    
    /**
     * This method used to return list record of Student by id
     * 
     * @param id the id of student
     * @return the list of record of Student by id
     */
    public ArrayList<Student> getListStudentById(String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : students) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }
    
    /**
     * This method used to select the record of a student you want to
     * delete or update then return it
     * 
     * @param listStudentFindByID the list record of a student
     * @return a record of student  you want to delete or update
     */
    public Student getStudentRecordByListFound(ArrayList<Student> listStudentFindByID) {
        System.out.println("List student found: ");
        int count = 0;
        System.out.println("+-----+---------------+----------+---------------+");
        System.out.printf("|%5s|%15s|%10s|%15s|\n", "No.", "Student Name",
                "Semester", "Course Name");
        System.out.println("+-----+---------------+----------+---------------+");
        for (Student student : listStudentFindByID) {
            System.out.printf("|%5s|%15s|%10s|%15s|\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.println("+-----+---------------+----------+---------------+");
        int choice = Validator.getInt("Enter choice student you want "
                + "to delete or update:",
                "Enter 0->" + (listStudentFindByID.size() - 1),
                "Invalid!", 0, listStudentFindByID.size() - 1);
        return listStudentFindByID.get(choice);
    }
    
    /**
     * This method used to display student(s) with total Courses of this student 
     */
    public void report() {
        /*use hash map to store information about the record and its
        occurrence in the list*/
        HashMap<String, Integer> reports = new HashMap<>();
        int count = 0;
        for (Student student : students) {
            //Key is string :"id#name student#name course"
            String key = student.getId() + "#" + student.getStudentName() +
                    "#" + student.getCourseName();
            if (reports.containsKey(key)) {
                int total = reports.get(key);
                reports.put(key, total + 1);
            } else {
                reports.put(key, 1);
            }
        }
        System.out.println("+-----+---------------+----------+---------------+");
        System.out.printf("|%5s|%15s|%10s|%15s|\n", "No.", "Student Name",
                "Course", "Total of Course");
        System.out.println("+-----+---------------+----------+---------------+");
        for (String key : reports.keySet()) {
            System.out.printf("|%5s|%15s|%10s|%15s|\n", count++, key.split("#")[1],
                    key.split("#")[2], reports.get(key));
        }
        System.out.println("+-----+---------------+----------+---------------+");
    }
    
    /**
     * This method used to generate many record of student to easy check program
     */
    public void generateStudent() {
        students.add(new Student("s1", "Tran Quoc Tuan", "Fall2022", "Java"));
        students.add(new Student("s1", "Tran Quoc Tuan", "Summer2022", ".NET"));
        students.add(new Student("s1", "Tran Quoc Tuan", "Fall2022", "C/C++"));
        students.add(new Student("s2", "Doan Duy Huy", "Fall2021", "Java"));
        students.add(new Student("s2", "Doan Duy Huy", "Spring2022", "Java"));
        students.add(new Student("s3", "Le Thi Hoa", "Fall2022", "C/C++"));
        students.add(new Student("s4", "Le Thi Quynh", "Fall2022", "Java"));
        students.add(new Student("s5", "Le Trong Nhat", "Fall2022", ".NET"));
        students.add(new Student("s5", "Le Trong Nhat", "Summer2022", "Java"));
        students.add(new Student("s6", "Le Van Quyen", "Fall2022", "Java"));
    }
}
