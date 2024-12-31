package prototypepattern;

public class IntelligentStudent extends Student {

    private int iq;

    public IntelligentStudent(IntelligentStudent intelligentStudent) {
        super(intelligentStudent);
        this.iq = intelligentStudent.iq;
    }

    public IntelligentStudent() {}

    public IntelligentStudent(int iq) {
        this.iq = iq;
    }

    public IntelligentStudent(int iq, int age, String name, String batch) {
        super(age, name, batch);
        this.iq = iq;
    }

    @Override
    public IntelligentStudent clone() {
        return new IntelligentStudent(this);
    }

    @Override
    public String toString() {

        return "IntelligentStudent{" +
                "iq=" + iq +
                '}' + super.toString();
    }
}
