import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Library library = new Library();

        boolean isWork = true;
        while(isWork){
            System.out.println("1-add a Book\n 2-get Books By Author\n 3-get Total Books Count\n 4-get Most Expensive Book\n 5-getBooksAfterYear\n 6-get Author With Most Books\n 7-group Books By Country\n 8-exit");
            int answer = scanner.nextInt();
            scanner.nextLine();
            if(answer == 1){
                System.out.print("Title: ");
                String title = scanner.nextLine();

                System.out.print("Year: ");
                int year = scanner.nextInt();

                System.out.print("Price: ");
                int price = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Author name: ");
                String name = scanner.nextLine();

                System.out.print("Country: ");
                String country = scanner.nextLine();

                Author author = new Author(name, country);
                Book book = new Book(title, year, price);

                library.addBook(author, book);
            }
            if(answer == 2) {
                System.out.print("Author name: ");
                String name = scanner.nextLine().trim();

                System.out.print("Country: ");
                String country = scanner.nextLine().trim();

                Author author = new Author(name, country);
                ArrayList<Book> books = library.getBooksByAuthor(author);

                if (books.isEmpty()) {
                    System.out.println("No books found.");
                } else {
                    for (Book b : books) {
                        System.out.println("Book: " + b.getTitle());
                    }
                }
            }
            if(answer == 3){
                System.out.println("Total books: " + library.getTotalBooksCount());
            }
            if(answer == 4){
                Book book = library.getMostExpensiveBook();
                if(book !=null){
                    System.out.println("Most expensive book:"  + book.getTitle() + " price: " + book.getPrice());
                }
            }
            if(answer == 5){
                System.out.println("year:");
                int year = scanner.nextInt();

                ArrayList<Book> books1 = library.getBooksAfterYear(year);

                for (Book b : books1){
                    System.out.println(b.getTitle());
                }
            }
            if(answer == 6){
                ArrayList<Book> book = library.getAuthorWithMostBooks();

                for(Book b : book){
                    System.out.println("Author with most books:" + b.getTitle());
                }
            }
            if(answer == 7) {
                HashMap<String, ArrayList<Book>> grouped = library.groupBooksByCountry();
                for(String country : grouped.keySet()){
                    System.out.println("Country:" + country);
                    for(Book b : grouped.get(country)){
                        System.out.println("-" + b.getTitle());
                    }
                }
            }
            if(answer == 8){
                System.out.println("Exiting...");
                isWork = false;
            }
        }
    }
}
