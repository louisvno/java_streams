import java.util.*;

public class Movie {
   private String title;
   private List <String> cast = new ArrayList();
   
   public Movie (String title) {
      this.title = title;
   }
  
  public String getTitle() {
    return this.title;
  }
  
  public void addCastMember(String name){ 
    this.cast.add(name);
  }
  public List <String> getCast() {
    return this.cast;
  }
  
  public String toString(){
    return this.title;
  }
}