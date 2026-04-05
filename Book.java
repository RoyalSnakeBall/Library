public class Book {
    private String title;
    private int year;
    private int price;

    public Book(String title, int year, int price) {
        this.price = price;
        this.title = title;
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }


}
