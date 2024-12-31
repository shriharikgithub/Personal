package prototypepattern;

public class Student {
    private int age;
    private String batch;
    private String name;

    Student(Student st) {
        this.age = st.age;
        this.name = st.name;
        this.batch = st.batch;
    }

    Student(int age, String name, String batch) {
        this.age = age;
        this.name = name;
        this.batch = batch;
    }

    Student() {}

    public Student clone() {
        return new Student(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", batch='" + batch + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
