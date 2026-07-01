public class ContentModerationDemo {
    interface TextModeration {
        boolean moderateText(String post);

        default void displayModerationPolicy() {
            System.out.println("Text policy: avoid offensive language.");
        }
    }

    interface SpamDetection {
        boolean detectSpam(String post);

        default void displayModerationPolicy() {
            System.out.println("Spam policy: block promotional or suspicious content.");
        }
    }

    static class ContentModerator implements TextModeration, SpamDetection {
        private final String[] posts;

        ContentModerator(String[] posts) {
            this.posts = posts;
        }

        @Override
        public boolean moderateText(String post) {
            return !containsRestrictedWords(post);
        }

        @Override
        public boolean detectSpam(String post) {
            String lower = post.toLowerCase();
            return lower.contains("buy now") || lower.contains("free money") || lower.contains("click here");
        }

        @Override
        public void displayModerationPolicy() {
            TextModeration.super.displayModerationPolicy();
            SpamDetection.super.displayModerationPolicy();
        }

        static boolean containsRestrictedWords(String post) {
            String lower = post.toLowerCase();
            return lower.contains("hate") || lower.contains("insult") || lower.contains("threat");
        }

        void analyzePosts() {
            displayModerationPolicy();
            for (String post : posts) {
                boolean spam = detectSpam(post);
                boolean offensive = !moderateText(post);

                if (spam) {
                    System.out.println("Spam post: " + post);
                } else if (offensive) {
                    System.out.println("Offensive post: " + post);
                } else {
                    System.out.println("Valid post: " + post);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] posts = {
                "Hello everyone, have a nice day",
                "Buy now and get rich fast",
                "You are an insult to this community",
                "Great weather today"
        };

        ContentModerator moderator = new ContentModerator(posts);
        moderator.analyzePosts();
    }
}
