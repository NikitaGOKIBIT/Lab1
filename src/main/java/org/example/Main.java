import java.util.ArrayList;
import java.util.List;

// Enum MovieGenre
enum MovieGenre {
    COMEDY, DRAMA, ACTION
}

// Клас Date
class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }
}

// Клас Director
class Director {
    private String name;
    private String surname;
    private Date birthdate;

    public Director(String name, String surname, Date birthdate) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public String toString() {
        return name + " " + surname + " (Born: " + birthdate + ")";
    }
}

// Клас Screening
class Screening {
    private String screeningName;
    private double profit;
    private Date screeningDate;

    public Screening(String screeningName, double profit, Date screeningDate) {
        this.screeningName = screeningName;
        this.profit = profit;
        this.screeningDate = screeningDate;
    }

    public double getProfit() {
        return profit;
    }

    public String toString() {
        return screeningName + " (" + screeningDate + "), Profit: " + profit;
    }
}

// Клас Movie
class Movie {
    private String title;
    private MovieGenre genre;
    private Director director;
    private List<Screening> screenings;

    public Movie(String title, MovieGenre genre, Director director) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.screenings = new ArrayList<>();
    }

    public void addScreening(Screening screening) {
        screenings.add(screening);
    }

    public void displayFullInfo() {
        System.out.println("Movie: " + title + " (" + genre + ")");
        System.out.println("Director: " + director);
        System.out.println("Screenings:");
        for (Screening s : screenings) {
            System.out.println("  " + s);
        }
    }

    public void displayShortInfo() {
        double totalProfit = 0;
        for (Screening s : screenings) {
            totalProfit += s.getProfit();
        }
        double averageProfit = screenings.size() > 0 ? totalProfit / screenings.size() : 0;
        System.out.println("Movie: " + title);
        System.out.println("Director: " + director);
        System.out.println("Average Profit: " + averageProfit);
    }
}

// Головний клас
public class Main {
    public static void main(String[] args) {
        // Створення об'єктів
        Director director = new Director("Christopher", "Nolan", new Date(30, 7, 1970));
        Movie movie = new Movie("Inception", MovieGenre.ACTION, director);

        movie.addScreening(new Screening("Screening 1", 1500.5, new Date(10, 7, 2010)));
        movie.addScreening(new Screening("Screening 2", 2000.0, new Date(12, 7, 2010)));

        // Вивід інформації
        movie.displayFullInfo();
        System.out.println();
        movie.displayShortInfo();
    }
}
