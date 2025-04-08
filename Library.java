import java.lang.reflect.Array;
import java.util.Hashtable;
import java.util.ArrayList;
public class Library extends Building implements LibraryRequirements{

  private Hashtable<String, Boolean> collection;

  /**
   * Constructor for a Library
   * @param n String name
   * @param a String address
   * @param f int number of floors
   */  
  public Library(String n, String a, int f) {
    super(n, a, f);
    collection = new Hashtable<String, Boolean>();

    System.out.println("You have built a library!");
  }

  /**
   * adds a title to the collection
   * @param title String of book's title and author
   */
  public void addTitle(String title){
    collection.put(title, true);
  }

  /**
   * adds multiple titles to the collection
   * @param titles ArrayList of book's title and author
   */
  public void addTitle(ArrayList<String> titles){
    for (String title : titles){
      collection.put(title, true);
    }
  }

  /**
   * removes book from collection
   * @param title book to be removed
   * @return book that was removed
   */
  public String removeTitle(String title){
    if (collection.remove(title) != null){
      return title;
    }else{
      return null;
    }
  } 

  /**
   * Changes title's value to false, if it was available
   * @param title Book to be checked out
   */
  public void checkOut(String title){
    if (collection.contains(title)){
      collection.put(title, false);
    }else{
      System.out.println("Title unavailable");
    }
  }

  /**
   * Changes title's value to false to check it out, if it was available
   * @param titles ArrayList of books to be checked out
   */
  public void CheckOut(ArrayList<String> titles){
    for (String title : titles){
      if (collection.contains(title)){
        collection.put(title, false);
      }else{
        System.out.println("Title unavailable");
      }
    }
  }

  /**
   * Changes title's value true
   * @param title book being returned 
   */
  public void returnBook(String title){
    collection.put(title, true);
  } 

  /**
   * checks if the Library has the title
   * @param title book to find
   * @return boolean, true if book is in collection
   */
  public boolean containsTitle(String title){
    return collection.containsKey(title); 
  }

  /**
   * returns title's value
   * @param title book to check
   * @return value of the title, true if available
   */
  public boolean isAvailable(String title){
    return collection.get(title);
  }

  /**
   * prints all titles and their keys
   */
  public void printCollection(){
    System.out.println(collection.toString());
  } 

  /**
   * prints all available options for the Library
   */
  public void showOptions(){
    super.showOptions();
    System.out.println("addTitle()\n removeTitle()\n checkOut()\n returnBook()\n containsTitle()\n isAvailable()\n printCollection()\n");

  }

  public static void main(String[] args) {
    Library myLibrary = new Library("City Library", "456 Main St", 2);

    myLibrary.addTitle("The Great Gatsby by F. Scott Fitzgerald");
    myLibrary.addTitle("To Kill a Mockingbird by Harper Lee");
    myLibrary.addTitle("1984 by George Orwell");

    myLibrary.printCollection(); 

    System.out.println(myLibrary.isAvailable("1984 by George Orwell")); // Expect true

    myLibrary.checkOut("1984 by George Orwell");

    System.out.println(myLibrary.isAvailable("1984 by George Orwell")); // Expect false

    myLibrary.returnBook("1984 by George Orwell");

    System.out.println(myLibrary.isAvailable("1984 by George Orwell")); // Expect true

    myLibrary.checkOut("The Catcher in the Rye by J.D. Salinger");

    myLibrary.removeTitle("To Kill a Mockingbird by Harper Lee");
    System.out.println(myLibrary.containsTitle("To Kill a Mockingbird by Harper Lee")); // Expect false

    myLibrary.printCollection(); 
  }
} 