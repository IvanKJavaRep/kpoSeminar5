import java.util.ArrayList;

public class Library {
    @Override
    public String toString() {
        String s = "";
        for (var el :
                listOfBooks) {
            s += el;
        }
        return s;
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

    private ArrayList<Book> listOfBooks = new ArrayList<>();


    public Library() {
        int[] years = {1999, 1915, 1930, 2005, 2017};
        String[] authors = {"Alexander Pushkin", "Lev Tolstoi", "Mikhail Letrmontov"};
        ArrayList<String[]> descriptions = new ArrayList<>();
        descriptions.add(new String[]{"Kapitanskaya Dochka", "Evgeniy Onegin", "Dubrovskiy"});
        descriptions.add(new String[]{"Voina and mir", "Anna Karenina", "Posle Bala"});
        descriptions.add(new String[]{"Borodino", "Mtsiri", "Demon"});
        for (int i = 0; i < authors.length; i++) {
            for (var el : descriptions.get(i)
            ) {
                for (int j = 0; j < years.length; j++) {
                    listOfBooks.add(new Book(el, authors[i], years[j]));
                }
            }
        }
    }

    public ArrayList<Book> getBook(String name) {
        ArrayList<Book> possibleBooks = new ArrayList<>();
        for (var el :
                listOfBooks) {
            if (el.getDescription().equals(name) && el.getQuantity() > 0) {
                possibleBooks.add(el);
            }
        }
        return possibleBooks;
    }


}
