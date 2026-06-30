public class EducationalCourseHierarchyDemo {
    public static void main(String[] args) {
        Course course = new Course("Java Basics", 4);
        OnlineCourse onlineCourse = new OnlineCourse("OOP in Java", 6, "Coursera", true);
        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Advanced Java", 8, "Udemy", false, 499, 10);

        course.displayInfo();
        onlineCourse.displayInfo();
        paidOnlineCourse.displayInfo();
    }

    static class Course {
        String courseName;
        int duration;

        Course(String courseName, int duration) {
            this.courseName = courseName;
            this.duration = duration;
        }

        void displayInfo() {
            System.out.println("Course: " + courseName + " | Duration: " + duration + " weeks");
        }
    }

    static class OnlineCourse extends Course {
        String platform;
        boolean isRecorded;

        OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
            super(courseName, duration);
            this.platform = platform;
            this.isRecorded = isRecorded;
        }

        @Override
        void displayInfo() {
            System.out.println("Online Course: " + courseName + " | Platform: " + platform + " | Recorded: " + isRecorded);
        }
    }

    static class PaidOnlineCourse extends OnlineCourse {
        double fee;
        double discount;

        PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
            super(courseName, duration, platform, isRecorded);
            this.fee = fee;
            this.discount = discount;
        }

        @Override
        void displayInfo() {
            System.out.println("Paid Online Course: " + courseName + " | Fee: " + fee + " | Discount: " + discount + "%");
        }
    }
}
