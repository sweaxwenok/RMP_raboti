public class Student implements Comparable<Student>{
    private String name;
    private String group;
    private double grade;

    public Student(String name, String group, double grade) {
        this.name = name;
        this.group = group;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public double getGrade() {
        return grade;
    }


    public String toString(){
        return "Имя: " + name + ", Группа: " + group + ", Класс: " + grade;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}