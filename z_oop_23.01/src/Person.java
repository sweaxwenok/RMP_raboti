class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Пол: " + gender);
    }

    public void increaseAge() {
        age++;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}