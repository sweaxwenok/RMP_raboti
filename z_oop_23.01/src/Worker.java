class Worker extends Person {
    private double salary;

    public Worker(String name, int age, String gender, double salary) {
        super(name, age, gender);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Worker {
    private int numberOfSubordinates;

    public Manager(String name, int age, String gender, double salary, int numberOfSubordinates) {
        super(name, age, gender, salary);
        this.numberOfSubordinates = numberOfSubordinates;
    }
}