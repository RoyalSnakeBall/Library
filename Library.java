import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    HashMap<Author, ArrayList<Book>> hashMaps = new HashMap<>();

    public void addBook(Author author, Book book){
        if(!hashMaps.containsKey(author)){
            ArrayList<Book> books = new ArrayList<>();
            books.add(book);

            hashMaps.put(author, books);
        }
        else{
            hashMaps.get(author).add(book);
        }
    }

    public ArrayList<Book> getBooksByAuthor(Author author){
        for (Author a : hashMaps.keySet()) {
            if (a.getName().equalsIgnoreCase(author.getName()) &&
                    a.getCountry().equalsIgnoreCase(author.getCountry())) {

                return hashMaps.get(a);
            }
        }
        for (Author a : hashMaps.keySet()) {
            System.out.println("Stored: " + a.getName() + " | " + a.getCountry());
        }

        System.out.println("Searching: " + author.getName() + " | " + author.getCountry());
        return new ArrayList<>();
    }
    public int getTotalBooksCount(){
        int total = 0;
        for(ArrayList<Book> books : hashMaps.values()){
            total += books.size();
        }
        return total;
    }
    public Book getMostExpensiveBook(){
        Book mostExpensive = null;
        for(ArrayList<Book> books : hashMaps.values()){
            for(Book book : books){
                if(mostExpensive == null ||
                book.getPrice() > mostExpensive.getPrice()) {
                    mostExpensive = book;
                }

            }
        }
        return mostExpensive;
    }
    public ArrayList<Book> getBooksAfterYear(int year){
        ArrayList<Book> result = new ArrayList<>();

        for(ArrayList<Book> books : hashMaps.values()){
            for(Book book : books){
                if(book.getYear() > year){
                    result.add(book);
                }
            }
        }
        return result;
    }
    public ArrayList<Book> getAuthorWithMostBooks(){
        ArrayList<Book> maxList = new ArrayList<>();
        for(ArrayList<Book> books : hashMaps.values()){
            if(books.size() > maxList.size()){
                maxList = books;

            }
        }
        return maxList;
    }
    public HashMap<String, ArrayList<Book>> groupBooksByCountry(){
        HashMap<String, ArrayList<Book>> grouped = new HashMap<>();

        for(Author author : hashMaps.keySet()){
            String country = author.getCountry();

            if(!grouped.containsKey(country)){
                grouped.put(country, new ArrayList<>());
            }

            grouped.get(country).addAll(hashMaps.get(author));
        }
        return grouped;
    }
}
