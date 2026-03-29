/* This is a stub for the Library class */

import java.util.Hashtable;
/**
 * Represents a Library building, which manages a collection of books
 */
public class Library extends Building implements LibraryRequirements {
    
  private Hashtable<String, Boolean> collection;
  /**
   * Construstor for the Library class
   * @param name The name of the library 
   * @param address The phyiscal location of the library
   * @param nFloors The number of floors in the library
   */

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

  /**
   * Adds a new title to the collection with an initial status of true (available)
   * @param title The title of the book to add
   */
    public void addTitle(String title) {
        this.collection.put(title, true);
    }

  /**
   * Removes a title from the collection entirely
   * @param title The title of the book to remove
   * @return The title of the removed book
   */
    public String removeTitle(String title) {
        this.collection.remove(title);
        return title;
    }
  /**
   * Marks a book as checked out (false)
   * @param title The title of the book to check out
   */
  public void checkOut(String title) {
      this.collection.replace(title, false);
  }

  /**
   * Marks a book as returned/available (true)
   * @param title The title of the book to return
   */
  public void returnBook(String title) {
      this.collection.replace(title, true);
  }

  /**
   * Checks if a title is part of the library's collection
   * @param title The title to search for
   * @return true if the book exists in the collection, false otherwise
   */
  public boolean containsTitle(String title) {
      return this.collection.containsKey(title);
  }

  /**
   * Checks if a title is currently available for checkout
   * @param title The title to check
   * @return true if available (value is true), false if checked out or not found
   */
  public boolean isAvailable(String title) {
      // We use get() to retrieve the Boolean value associated with the title
      return this.collection.getOrDefault(title, false);
  }

  /**
   * Prints the entire library collection with availability status
   */
  public void printCollection() {
      System.out.println("--- Library Collection ---");
      for (String title : this.collection.keySet()) {
          boolean available = this.collection.get(title);
          String status = available ? "[Available]" : "[Checked Out]";
          System.out.println(title + " " + status);
      }
  }
    public static void main(String[] args) {
      Library smithLib = new Library("Hillyer Library", "1 elm street", 2);
      
      smithLib.addTitle("The Notebook");
      smithLib.addTitle("The Hate U Love");

      smithLib.checkOut("The Notebook");
      smithLib.printCollection();
    }
  
  }