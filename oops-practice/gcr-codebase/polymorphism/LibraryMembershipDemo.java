public class LibraryMembershipDemo {
    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("Aman", "S100"),
            new FacultyMember("Neha", "F200"),
            new GuestMember("Ravi", "G300")
        };

        for (LibraryMember member : members) {
            member.printDetails();
            System.out.println("Fine for 5 overdue days: " + member.calculateFine(5));
            System.out.println();
        }

        String searchId = "F200";
        System.out.println("Search result for " + searchId + ":");
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(searchId)) {
                member.printDetails();
            }
        }
    }

    static class LibraryMember {
        String memberName;
        String memberId;

        LibraryMember(String memberName, String memberId) {
            this.memberName = memberName;
            this.memberId = memberId;
        }

        double calculateFine(int overdueDays) {
            return overdueDays * 1.0;
        }

        void printDetails() {
            System.out.println("Member: " + memberName + " (" + memberId + ")");
        }

        String getMemberId() {
            return memberId;
        }
    }

    static class StudentMember extends LibraryMember {
        StudentMember(String memberName, String memberId) {
            super(memberName, memberId);
        }

        @Override
        double calculateFine(int overdueDays) {
            return overdueDays * 0.5;
        }
    }

    static class FacultyMember extends LibraryMember {
        FacultyMember(String memberName, String memberId) {
            super(memberName, memberId);
        }

        @Override
        double calculateFine(int overdueDays) {
            return overdueDays * 0.25;
        }
    }

    static class GuestMember extends LibraryMember {
        GuestMember(String memberName, String memberId) {
            super(memberName, memberId);
        }

        @Override
        double calculateFine(int overdueDays) {
            return overdueDays * 1.5;
        }
    }
}
