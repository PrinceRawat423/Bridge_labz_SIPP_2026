public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book = new Book();
        book.setItemId(1);
        book.setTitle("Java Basics");
        book.setAuthor("James");

        Magazine magazine = new Magazine();
        magazine.setItemId(2);
        magazine.setTitle("Tech Monthly");
        magazine.setAuthor("Editor Team");

        DVD dvd = new DVD();
        dvd.setItemId(3);
        dvd.setTitle("Learning Java");
        dvd.setAuthor("Trainer");

        displayItem(book);
        displayItem(magazine);
        displayItem(dvd);
    }

    private static void displayItem(LibraryItem item) {
        item.displayItemDetails();
        System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
        System.out.println();
    }
}

abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public abstract int getLoanDuration();
}

class Book extends LibraryItem {
    @Override
    public int getLoanDuration() {
        return 14;
    }
}

class Magazine extends LibraryItem {
    @Override
    public int getLoanDuration() {
        return 7;
    }
}

class DVD extends LibraryItem {
    @Override
    public int getLoanDuration() {
        return 3;
    }
}
