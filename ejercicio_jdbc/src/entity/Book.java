package entity;
public class Book {
    private int id;
    private String title;
    private int year_publication;
    private double price;
    private int id_author;

    //Constructor
    public Book(int id, String title, int year_publication, double price, int id_author) {
        this.id = id;
        this.title = title;
        this.year_publication = year_publication;
        this.price = price;
        this.id_author = id_author;
    }
    public Book() {
    }

    //Getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear_publication() {
        return year_publication;
    }

    public void setYear_publication(int year_publication) {
        this.year_publication = year_publication;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    //To string

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year_publication=" + year_publication +
                ", price=" + price +
                ", id_author=" + id_author +
                '}';
    }
}
