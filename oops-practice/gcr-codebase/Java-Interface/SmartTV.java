interface StreamingService {
    void streamMovie(String movieName);

    default void showSubscriptionDetails() {
        System.out.println("StreamingService subscription: Basic plan includes movies and shows.");
    }
}

interface GamingService {
    void playGame(String gameName);

    default void showSubscriptionDetails() {
        System.out.println("GamingService subscription: Includes arcade and premium titles.");
    }
}

class SmartTV implements StreamingService, GamingService {
    private String[] movies;
    private String[] games;

    public SmartTV(String[] movies, String[] games) {
        this.movies = movies;
        this.games = games;
    }

    @Override
    public void streamMovie(String movieName) {
        System.out.println("Streaming movie: " + movieName);
    }

    @Override
    public void playGame(String gameName) {
        System.out.println("Playing game: " + gameName);
    }

    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public void showAvailableContent() {
        System.out.println("Available Movies:");
        for (String movie : movies) {
            System.out.println("- " + movie);
        }
        System.out.println("Available Games:");
        for (String game : games) {
            System.out.println("- " + game);
        }
    }

    public static void main(String[] args) {
        String[] movies = {"Matrix", "Inception", "The Social Network"};
        String[] games = {"FIFA 26", "Minecraft", "Fortnite"};
        SmartTV tv = new SmartTV(movies, games);
        tv.showSubscriptionDetails();
        tv.showAvailableContent();
    }
}
