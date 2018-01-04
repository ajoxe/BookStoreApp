package nyc.c4q.bookstoreapp.model;

/**
 * Created by amirahoxendine on 12/13/17.
 */

public class Book {
    String id;
    String [] cat;
    String name;
    String author;
    String series_t;
    int sequence_i;
    String genre_s;
    boolean instock;
    double price;
    int pages_i;

   /* public Book(String id, String[] cat, String name, String author, String series_t, int sequence_i, String genre_s, boolean instock, double price, int pages_i) {
        this.id = id;
        this.cat = cat;
        this.name = name;
        this.author = author;
        this.series_t = series_t;
        this.sequence_i = sequence_i;
        this.genre_s = genre_s;
        this.instock = instock;
        this.price = price;
        this.pages_i = pages_i;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getCat() {
        return cat;
    }

    public void setCat(String[] cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeries_t() {
        return series_t;
    }

    public void setSeries_t(String series_t) {
        this.series_t = series_t;
    }

    public int getSequence_i() {
        return sequence_i;
    }

    public void setSequence_i(int sequence_i) {
        this.sequence_i = sequence_i;
    }

    public String getGenre_s() {
        return genre_s;
    }

    public void setGenre_s(String genre_s) {
        this.genre_s = genre_s;
    }

    public boolean isInstock() {
        return instock;
    }

    public void setInstock(boolean instock) {
        this.instock = instock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages_i() {
        return pages_i;
    }

    public void setPages_i(int pages_i) {
        this.pages_i = pages_i;
    }
}
