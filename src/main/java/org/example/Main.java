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

    @Override
    public String toString() {
        return name + " " + surname + " (Born: " + birthdate + ")";
    }
}

// Підклас FilmDirector
class FilmDirector extends Director {
    private int numberOfAwards;
    private String famousMovie;

    public FilmDirector(String name, String surname, Date birthdate, int numberOfAwards, String famousMovie) {
        super(name, surname, birthdate);
        this.numberOfAwards = numberOfAwards;
        this.famousMovie = famousMovie;
    }

    @Override
    public String toString() {
        return super.toString() + ", Awards: " + numberOfAwards + ", Famous Movie: " + famousMovie;
    }
}

// Підклас DocumentaryDirector
class DocumentaryDirector extends Director {
    private int numberOfDocumentaries;
    private String specializationTopic;

    public DocumentaryDirector(String name, String surname, Date birthdate, int numberOfDocumentaries, String specializationTopic) {
        super(name, surname, birthdate);
        this.numberOfDocumentaries = numberOfDocumentaries;
        this.specializationTopic = specializationTopic;
    }

    @Override
    public String toString() {
        return super.toString() + ", Documentaries: " + numberOfDocumentaries + ", Specialization: " + specializationTopic;
    }
}

// Клас Movie
class Movie {
    private String title;
    private MovieGenre genre;
    private Director director;

    public Movie(String title, MovieGenre genre, Director director) {
        this.title = title;
        this.genre = genre;
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie: " + title + " (" + genre + "), Directed by: " + director;
    }
}

// Головний клас
public class Main {
    public static void main(String[] args) {
        // Створення об'єктів Director
        Director generalDirector = new Director("Christopher", "Nolan", new Date(30, 7, 1970));
        FilmDirector filmDirector = new FilmDirector("Quentin", "Tarantino", new Date(27, 3, 1963), 9, "Pulp Fiction");
        DocumentaryDirector docDirector = new DocumentaryDirector("David", "Attenborough", new Date(8, 5, 1926), 25, "Nature");

        // Створення об'єктів Movie
        Movie movie1 = new Movie("Inception", MovieGenre.ACTION, generalDirector);
        Movie movie2 = new Movie("Kill Bill", MovieGenre.ACTION, filmDirector);
        Movie movie3 = new Movie("Our Planet", MovieGenre.DRAMA, docDirector);

        // Вивід інформації
        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println(movie3);
    }
}
