interface TextModeration {
    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("TextModeration policy: Remove offensive language and hate speech.");
    }

    static boolean containsRestrictedWords(String post) {
        String[] restricted = {"spam", "hate", "abuse", "offensive"};
        if (post == null) {
            return false;
        }
        String lowered = post.toLowerCase();
        for (String word : restricted) {
            if (lowered.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

interface SpamDetection {
    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("SpamDetection policy: Flag duplicate, bulk or promotional spam.");
    }
}

class ContentModerator implements TextModeration, SpamDetection {
    @Override
    public boolean isOffensive(String post) {
        return TextModeration.containsRestrictedWords(post);
    }

    @Override
    public boolean isSpam(String post) {
        return post != null && post.toLowerCase().contains("buy now");
    }

    @Override
    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public void moderate(String[] posts) {
        for (String post : posts) {
            String result;
            if (isSpam(post)) {
                result = "SPAM";
            } else if (isOffensive(post)) {
                result = "OFFENSIVE";
            } else {
                result = "VALID";
            }
            System.out.println(post + " => " + result);
        }
    }

    public static void main(String[] args) {
        String[] posts = {
            "Buy now and save big!",
            "I hate this product",
            "Enjoying the new release",
            "This is abusive language",
            "Great content for everyone"
        };
        ContentModerator moderator = new ContentModerator();
        moderator.displayModerationPolicy();
        moderator.moderate(posts);
    }
}
