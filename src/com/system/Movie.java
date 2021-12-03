import java.util.*;
import ShowTime;

public class Movie{

    public static ArrayList<Movie> movieList = new ArrayList<Movie>();

    String title;
    double price;
    Arraylist<ShowTimes> showtimes;


    public Movie(String title, double price, ArrayList<ShowTime> showtimes){
        this.title = title;
        this.price  = price;
        this.showtimes = showtimes;

        this.movieList.add(this.Movie)
    }

    public String getTitle(){ return this.title; }
    public double getPrice(){ return this.price; }
    public ArrayList<ShowTime> getShowTimes(){ return this.showtimes; }
    
    public void setPrice(double price){ this.price = price; }
    public void addShowtime(ShowTime newTime){ this.showtimes.add(newTime); }
}
