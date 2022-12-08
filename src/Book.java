import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Book {
    private String description;
    private String Authors;
    private int yearOfPublishing;

    public int getQuantity() {
        return quantity;
    }

    private int quantity;

    public Book(String description, String authors, int yearOfPublishing) {
        this.description = description;
        Authors = authors;
        this.yearOfPublishing = yearOfPublishing;
        quantity = ThreadLocalRandom.current().nextInt(0,11);
    }

    public String getDescription() {
        return description;
    }

    public String getAuthors() {
        return Authors;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    @Override
    public String toString() {
        return "Book{" +
                "description='" + description + '\'' +
                ", Authors='" + Authors + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", quantity=" + quantity +
                '}'+"\n";
    }
    public String printWithoutQuantity()
    {
        return "Book{" +
                "description='" + description + '\'' +
                ", Authors='" + Authors + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                '}'+"\n";
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthors(String authors) {
        Authors = authors;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
