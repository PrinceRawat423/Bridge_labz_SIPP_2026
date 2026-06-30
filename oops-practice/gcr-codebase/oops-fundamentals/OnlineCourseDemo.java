public class OnlineCourseDemo {
    public static void main(String[] args) {
        Course course1 = new Course("Java Basics", 6, 5000);
        Course course2 = new Course("Spring Boot", 8, 7000);
        Course.updateInstituteName("BridgeLabz Academy");

        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }

    static class Course {
        String courseName;
        int duration;
        double fee;
        static String instituteName = "Unknown Academy";

        Course(String courseName, int duration, double fee) {
            this.courseName = courseName;
            this.duration = duration;
            this.fee = fee;
        }

        void displayCourseDetails() {
            System.out.println(courseName + " for " + duration + " weeks costs " + fee + " at " + instituteName);
        }

        static void updateInstituteName(String newName) {
            instituteName = newName;
        }
    }
}
