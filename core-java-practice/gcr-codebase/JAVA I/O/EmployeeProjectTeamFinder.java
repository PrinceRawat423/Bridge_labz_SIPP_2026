import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeProjectTeamFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] skillScores = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter skill score for employee " + (i + 1) + ": ");
            skillScores[i] = sc.nextInt();
        }

        System.out.print("Enter target skill score: ");
        int target = sc.nextInt();

        List<Integer> currentTeam = new ArrayList<>();
        findTeams(skillScores, 0, target, currentTeam);
        sc.close();
    }

    private static void findTeams(int[] skills, int index, int target, List<Integer> currentTeam) {
        if (target == 0) {
            System.out.println(currentTeam);
            return;
        }

        if (index == skills.length || target < 0) {
            return;
        }

        currentTeam.add(skills[index]);
        findTeams(skills, index + 1, target - skills[index], currentTeam);
        currentTeam.remove(currentTeam.size() - 1);

        findTeams(skills, index + 1, target, currentTeam);
    }
}
