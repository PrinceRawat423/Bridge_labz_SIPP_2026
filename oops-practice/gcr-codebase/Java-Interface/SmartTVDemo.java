public class SmartTVDemo {
    interface StreamingService {
        void streamMovie(String movie);

        default void showSubscriptionDetails() {
            System.out.println("Streaming subscription active.");
        }
    }

    interface GamingService {
        void playGame(String game);

        default void showSubscriptionDetails() {
            System.out.println("Gaming subscription active.");
        }
    }

    static class SmartTV implements StreamingService, GamingService {
        private final String[] movies;
        private final String[] games;

        SmartTV(String[] movies, String[] games) {
            this.movies = movies;
            this.games = games;
        }

        @Override
        public void streamMovie(String movie) {
            System.out.println("Streaming movie: " + movie);
        }

        @Override
        public void playGame(String game) {
            System.out.println("Playing game: " + game);
        }

        @Override
        public void showSubscriptionDetails() {
            StreamingService.super.showSubscriptionDetails();
            GamingService.super.showSubscriptionDetails();
        }

        void displayAvailableContent() {
            System.out.println("Available Movies:");
            for (String movie : movies) {
                System.out.println("- " + movie);
            }

            System.out.println("Available Games:");
            for (String game : games) {
                System.out.println("- " + game);
            }
        }
    }

    public static void main(String[] args) {
        String[] movies = {"Inception", "Interstellar", "Avatar"};
        String[] games = {"Chess", "Tetris", "FIFA"};

        SmartTV tv = new SmartTV(movies, games);
        tv.showSubscriptionDetails();
        tv.displayAvailableContent();
        tv.streamMovie("Inception");
        tv.playGame("Chess");
    }
}
