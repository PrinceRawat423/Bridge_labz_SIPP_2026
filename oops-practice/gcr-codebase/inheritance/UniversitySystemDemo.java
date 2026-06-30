public class UniversitySystemDemo {
    public static void main(String[] args) {
        Person person = new Person("Asha", 30);
        Student student = new Student("Ravi", 20, "S1001", 8.7);
        GradStudent gradStudent = new GradStudent("Meera", 25, "S1002", 9.2, "AI in Healthcare");

        System.out.println(person);
        System.out.println(student);
        System.out.println(gradStudent);

        System.out.println("Is Student a Person? " + (student instanceof Person));
        System.out.println("Is GradStudent a Student? " + (gradStudent instanceof Student));
        System.out.println("Is GradStudent a Person? " + (gradStudent instanceof Person));
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    static class Student extends Person {
        final String studentId;
        double gpa;

        Student(String name, int age, String studentId, double gpa) {
            super(name, age);
            this.studentId = studentId;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + ", studentId='" + studentId + "', gpa=" + gpa + "}";
        }
    }

    static class GradStudent extends Student {
        String thesis;

        GradStudent(String name, int age, String studentId, double gpa, String thesis) {
            super(name, age, studentId, gpa);
            this.thesis = thesis;
        }

        @Override
        public String toString() {
            return "GradStudent{name='" + name + "', age=" + age + ", studentId='" + studentId + "', gpa=" + gpa + ", thesis='" + thesis + "'}";
        }
    }
}
