import java.util.Objects;

public class Author {
    private String name;
    private String country;

    public Author(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(country, author.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }
}
