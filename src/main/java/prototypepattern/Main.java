package prototypepattern;

public class Main {
    public static void main(String[] args) {
        Student aprilStudent = new Student(0, null, "April");
        Student aprilIntelligentStudent = new IntelligentStudent(10, 0, null, "April - Intelligent");

        StudentPrototypeRegistry s = new StudentPrototypeRegistryImpl();
        s.addPrototype(StudentType.STUDENT, aprilStudent);
        s.addPrototype(StudentType.INTELLIGENCE_STUDENT, aprilIntelligentStudent);

        Student newAprilStudent = s.getPrototype(StudentType.STUDENT).clone();
        Student newAprilIntelligentStudent = s.getPrototype(StudentType.INTELLIGENCE_STUDENT).clone();

        System.out.println(aprilStudent.hashCode());
        System.out.println(aprilIntelligentStudent.hashCode());
        System.out.println(newAprilStudent.toString() + newAprilStudent.hashCode());
        System.out.println(newAprilIntelligentStudent.toString() + newAprilIntelligentStudent.hashCode());
    }
}
