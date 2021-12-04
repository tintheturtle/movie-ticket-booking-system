import java.util.*;

public class ShowTime{

    String day;                 // MM/DD/YY format
    ArrayList<String> times;    // HR:MI AM/PM format

    public ShowTime(String day, double time){
        this.day = day;
        this.times = new ArrayList<String>(time);
    }

    @Override
    public ShowTime(String day, ArrayList<String> times){
        this.day = day;
        this.times = times
    }

    /* Formatted as such for showMovies() in Main */
    public String toString()
    {
        return this.day;
    }

    
}
