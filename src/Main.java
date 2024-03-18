// LinkedList (Связный список)
// dd-dd-dddd

import enums.Genre;
import service.MovieFindableService;
import service.MovieService;
import service.MovieSortableService;
import service.serviceImpl.MovieFindableServiceImpl;
import service.serviceImpl.MovieServiceImpl;
import service.serviceImpl.MovieSortableServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerLn = new Scanner(System.in);

        MovieService movieService = new MovieServiceImpl();
        MovieFindableService movieFindableService = new MovieFindableServiceImpl();
        MovieSortableService movieSortableService = new MovieSortableServiceImpl();

        while (true) {
            System.out.println("""
                    ---------- Todos ----------
                    What action do you want to take?
                    1. Add movie
                    2. Update movie
                    3. Delete movie
                    4. Get all movies
                    5. Find movie by parameters
                    6. Sortable movie by parameters
                    """);
            switch (scannerNum.nextInt()) {
                case 1:
                    System.out.println(movieService.addMovie());
                    break;
                case 2:
                    movieService.updateMovie();
                    break;
                case 3:
                    movieService.deleteMovie();
                    break;
                case 4:
                    System.out.println(movieFindableService.getAllMovies());
                    break;
                case 5:
                    while (true) {
                        System.out.println("""
                                What parameters do you want to find by  ?
                                1. Find movie by full name or part name
                                2. Find movie by actor name
                                3. Find movie by year
                                4. Find movie by producer
                                5. Find movie by genre
                                6. Find movie by role
                                7. Exit search bar
                                """);

                        int command = scannerNum.nextInt();

                        if (command == 7) {
                            break;
                        }

                        switch (command) {
                            case 1:
                                System.out.println("Write movie full name or part name: ");

                                String fullOrPartName = scannerLn.nextLine();
                                System.out.println(movieFindableService.findMovieByFullNameOrPartName(fullOrPartName));
                                break;
                            case 2:
                                System.out.println("Write actor name: ");

                                String actorName = scannerLn.nextLine();
                                System.out.println(movieFindableService.findMovieByActorName(actorName));
                                break;
                            case 3:
                                System.out.println("Write movie year: ");
                                int year = scannerNum.nextInt();

                                System.out.println("Write the month of cinema digitally: ");
                                int month = scannerNum.nextInt();

                                System.out.println("Write movie day: ");
                                int day = scannerNum.nextInt();

                                LocalDate date = LocalDate.of(year, month, day);
                                System.out.println(movieFindableService.findMovieByYear(date));
                                break;
                            case 4:
                                System.out.println("Write producer name: ");

                                String producerName = scannerLn.nextLine();
                                System.out.println(movieFindableService.findMovieByProducer(producerName));
                                break;
                            case 5:
                                System.out.println("Write movie genre: ");

                                Genre genre = Genre.FANTASTIC;
                                System.out.println(movieFindableService.findMovieByGenre(genre));
                                break;
                            case 6:
                                System.out.println("Write movie role: ");

                                String role = scannerLn.nextLine();
                                System.out.println(movieFindableService.findMovieByRole(role));
                                break;
                            default:
                                System.out.println("Wrong action!");
                        }
                    }
                    break;
                case 6:
                    while (true) {
                        System.out.println("""
                                What parameters do you want to sort by  ?
                                1. Sort movie by name
                                2. Sort movie by year
                                3. Sort movie by producer
                                4. Exit sort bar
                                """);

                        int command = scannerNum.nextInt();

                        if (command == 4) {
                            break;
                        }

                        switch (command) {
                            case 1:
                                System.out.println("Select asc or desc?");
                                movieSortableService.sortMovieByName(scannerLn.nextLine());
                                break;
                            case 2:
                                System.out.println("Select asc or desc?");
                                movieSortableService.sortByYear(scannerLn.nextLine());
                                break;
                            case 3:
                                System.out.println("Sort by name or last name? (firstname/lastname)");
                                movieSortableService.sortByProducer(scannerLn.nextLine());
                            default:
                                System.out.println("Wrong action!");
                        }
                    }
                default:
                    System.out.println("Wrong action!");
            }
        }
    }
}

























































