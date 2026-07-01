public class DisasterRescueDemo {
    public static void main(String[] args) {
        RescueTeam[] teams = {
            new MedicalTeam("T001", "Zone A"),
            new FireRescueTeam("T002", "Zone B"),
            new FoodSupplyTeam("T003", "Zone A")
        };

        for (RescueTeam team : teams) {
            team.performDuty();
        }

        System.out.println("Teams in Zone A:");
        findTeamByLocation(teams, "Zone A");
        System.out.println("Teams starting with T: ");
        displayTeamsByPrefix(teams, "T");
        countTeams(teams);
    }

    static void findTeamByLocation(RescueTeam[] teams, String location) {
        for (RescueTeam team : teams) {
            if (team.location.equals(location)) {
                System.out.println(team.teamId + " " + team.getClass().getSimpleName());
            }
        }
    }

    static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        for (RescueTeam team : teams) {
            if (team.teamId.startsWith(prefix)) {
                System.out.println(team.teamId + " " + team.location + " " + team.getClass().getSimpleName());
            }
        }
    }

    static void countTeams(RescueTeam[] teams) {
        int medical = 0, fire = 0, food = 0;
        for (RescueTeam team : teams) {
            if (team instanceof MedicalTeam) medical++;
            else if (team instanceof FireRescueTeam) fire++;
            else if (team instanceof FoodSupplyTeam) food++;
        }
        System.out.println("Medical: " + medical + ", Fire: " + fire + ", Food: " + food);
    }

    static abstract class RescueTeam {
        String teamId;
        String location;

        RescueTeam(String teamId, String location) {
            this.teamId = teamId;
            this.location = location;
        }

        abstract void performDuty();
    }

    static class MedicalTeam extends RescueTeam {
        MedicalTeam(String teamId, String location) {
            super(teamId, location);
        }

        @Override
        void performDuty() {
            System.out.println(teamId + " treats patients in " + location);
        }
    }

    static class FireRescueTeam extends RescueTeam {
        FireRescueTeam(String teamId, String location) {
            super(teamId, location);
        }

        @Override
        void performDuty() {
            System.out.println(teamId + " extinguishes fire in " + location);
        }
    }

    static class FoodSupplyTeam extends RescueTeam {
        FoodSupplyTeam(String teamId, String location) {
            super(teamId, location);
        }

        @Override
        void performDuty() {
            System.out.println(teamId + " delivers food in " + location);
        }
    }
}
