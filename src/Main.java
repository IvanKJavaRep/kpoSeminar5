import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static int readNumber(int size) throws IOException {
        int n;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите номер книги:");
        n = Integer.parseInt(bufferedReader.readLine());
        while (n < 0 || n > size - 1) {
            System.out.println("Введите номер книги:");
            n = Integer.parseInt(bufferedReader.readLine());
        }
        return n;

    }

    public static ArrayList<Book> getBook(String name, ArrayList<Book> borrowed) {
        ArrayList<Book> possibleBooks = new ArrayList<>();
        for (var el :
                borrowed) {
            System.out.println(el.getDescription());
            if (el.getDescription().equals(name)) {
                possibleBooks.add(el);
            }
        }
        return possibleBooks;
    }

    public static void main(String[] args) throws IOException {
        Library library = new Library();
        ArrayList<Book> borrowedBooks = new ArrayList<>();
        String input = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        input = bufferedReader.readLine();
        while (!input.equals("exit")) {
            String[] tokens = input.split(" ", 2);
            if (tokens[0].equals("/get")) {
                try {
                    ArrayList<Book> books = library.getBook(tokens[1]);
                    int i = 0;
                    for (var b :
                            books) {
                        System.out.println(i + " " + b);
                        i++;
                    }
                    int chosen = readNumber(books.size());
                    books.get(chosen).setQuantity(books.get(chosen).getQuantity() - 1);
                    borrowedBooks.add(books.get(chosen));
                } catch (Exception ex) {
                    System.out.println("Введите название еще раз");
                }
            } else if (tokens[0].equals("/put")) {
                try {
                    if (borrowedBooks.isEmpty()) {
                        System.out.println("No borrowed books");
                    } else {
                        var books = getBook(tokens[1], borrowedBooks);
                        int i = 0;
                        for (var b :
                                books) {
                            System.out.println(i + " " + b.printWithoutQuantity());
                            i++;
                        }
                        int chosen = readNumber(books.size());
                        books.get(chosen).setQuantity(books.get(chosen).getQuantity() + 1);
                        library.getListOfBooks().add(books.get(chosen));
                        borrowedBooks.remove(books.get(chosen));
                    }
                } catch (Exception ex) {
                    System.out.println("Введите имя еще раз");
                }
            } else if (tokens[0].equals("/list")) {
                if (borrowedBooks.isEmpty()) {
                    System.out.println("No borrowed books");
                } else {
                    for (var el :
                            borrowedBooks) {
                        System.out.println(el.printWithoutQuantity());
                    }
                }
            } else if (tokens[0].equals("/all")) {
                System.out.println(library);
            }
            input = bufferedReader.readLine();

        }
        bufferedReader.close();
    }

}