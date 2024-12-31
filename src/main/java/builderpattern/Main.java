package builderpattern;


public class Main {
    public static void main(String[] args) throws Exception {
        Student s = Student.getBuilder().
                setAge(10)
                .setBatch("april")
                .setName("Shrihari")
                .setPsp(5)
                .validate()
                .build();

        System.out.println(s);
    }
}
