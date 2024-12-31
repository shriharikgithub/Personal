package prototypepattern;

import java.util.HashMap;
import java.util.Map;

public class StudentPrototypeRegistryImpl implements StudentPrototypeRegistry {
    Map<StudentType, Student> prototypes;

    public StudentPrototypeRegistryImpl() {
        prototypes = new HashMap<>();
    }

    @Override
    public void addPrototype(StudentType studentType, Student studentPrototype) {
        prototypes.put(studentType, studentPrototype);
    }

    @Override
    public Student getPrototype(StudentType studentType) {
        return prototypes.get(studentType);
    }

    @Override
    public Student clone(StudentType studentType) {
        return prototypes.get(studentType).clone();
    }
}
