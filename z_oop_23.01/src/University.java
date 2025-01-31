import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {
    private List<Student> students;

    public University() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortByStudentName(){
        Collections.sort(students);
    }

    public List<Student> filterStudentsByGrade(double minGrade) {
        List<Student> filteredStudents = new ArrayList<>();
        for(Student student: students){
            if(student.getGrade() >= minGrade){
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public void displayAllStudents(){
        for (Student student: students){
            System.out.println(student.toString());
        }
    }
}