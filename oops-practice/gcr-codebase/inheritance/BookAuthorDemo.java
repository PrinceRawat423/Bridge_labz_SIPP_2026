public class BookAuthorDemo {
    public static void main(String[] args) {
        Book book = new Book("Clean Code", 2008);
        Author author = new Author("Robert C. Martin", "Legendary programmer", "Clean Code", 2008);

        book.displayInfo();
        author.displayInfo();
    }

    static class Book {
        String title;
        int publicationYear;

        Book(String title, int publicationYear) {
            this.title = title;
            this.publicationYear = publicationYear;
        }

        void displayInfo() {
            System.out.println("Book: " + title + " (" + publicationYear + ")");
        }
    }

    static class Author extends Book {
        String name;
        String bio;

        Author(String name, String bio, String title, int publicationYear) {
            super(title, publicationYear);
            this.name = name;
            this.bio = bio;
        }

        @Override
        void displayInfo() {
            System.out.println("Author: " + name);
            System.out.println("Bio: " + bio);
            System.out.println("Book: " + title + " (" + publicationYear + ")");
        }
    }
}
