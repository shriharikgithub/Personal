package builderpattern;

import lombok.Getter;

@Getter
public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", batch='" + batch + '\'' +
                ", psp=" + psp +
                '}';
    }

    private int age;
    private String name;
    private String batch;
    private int psp;

    private Student() {}

    private Student(Builder b) {
        this.age = b.getAge();
        this.name = b.getName();
        this.batch = b.getBatch();
        this.psp = b.getPsp();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    static class Builder {
        private int age;
        private String name;
        private String batch;
        private int psp;

        public Builder validate() throws Exception {
            if (age < 0) {
                throw new Exception("Error in definging age");
            }
            return this;
        }

        public Student build() {
            return new Student(this);
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public String getBatch() {
            return batch;
        }

        public int getPsp() {
            return psp;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public Builder setPsp(int psp) {
            this.psp = psp;
            return this;
        }
    }
}

