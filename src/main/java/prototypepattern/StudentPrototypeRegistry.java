package prototypepattern;

public interface StudentPrototypeRegistry {
    void addPrototype(StudentType student, Student studentPrototype);
    Student getPrototype(StudentType studentType);
    Student clone(StudentType studentTye);
}
