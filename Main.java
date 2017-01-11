import java.util.*;
import java.util.stream.Collectors;

public class Main {
  
  public static void main(String [ ] args)
  {
    Set <Movie> movieDatabase = new HashSet<Movie>();
    
    Movie movie1 = new Movie ("the Matrix");
    Movie movie2 = new Movie ("Passengers");
    
    movie1.addCastMember("Keanu Reeves");
    movie1.addCastMember("Carrie-Anne Moss");
    movie2.addCastMember("Jenifer Lawrence");
    movie2.addCastMember("Chris Pratt");
    
    movieDatabase.add(movie1);
    movieDatabase.add(movie2);
    
    //print each Movie
    movieDatabase.stream()
            .forEach(System.out::println);
            
    //print actors for each Movie (one list per movie)
    movieDatabase.stream()
            .map(e -> e.getCast())
            .forEach(System.out::println); 
            
    //print actors seperately
    movieDatabase.stream()
            .map(movie -> movie.getCast())
            .flatMap(cast -> cast.stream()) //stream cast list and then each actor individually and flatten
            .forEach(System.out::println);
            
    //put all actors in a list       
    List <String> allActors = movieDatabase.stream()
            .map(movie -> movie.getCast())
            .flatMap(cast -> cast.stream()) //stream cast list and then each actor individually and flatten
            .collect(Collectors.toList());
    
    System.out.println(allActors);
    
    //put all actors in a list with method references      
    List <String> allActors1 = movieDatabase.stream()
            .map(Movie::getCast)
            .flatMap(List::stream) //stream cast list and then each actor individually and flatten
            .collect(Collectors.toList());
    
    System.out.println(allActors1);
            
  }

}