//Evan Phillips
//The interface for the BookCatalog class

package assg66_Phillipsev20;

import java.util.ArrayList;

public interface BookCatalogInterface {
	
	/**
     * Load the data containing all the books from a given file
     * @param fileName the name of the file to load
     */
	
	void loadData(String fileName);
	  
	/**
     * Display all the books in the catalog
     */
	
	 void displayCatalog();
	 
	 /**
	     * Search for a book by title
	     * @param title the title of the book to search for
	     * @return the Book object if found, or null if not found
	     */
	  
	 Book searchForBook(String title);
	 
	 /**
	     * Add a new book to the catalog
	     * @param isbn the ISBN of the book to add
	     * @param title the title of the book to add
	     * @param author the author of the book to add
	     * @param publisher the publisher of the book to add
	     * @param publishingYear the publishing year of the book to add
	     * @return true if the book is added, false if the book already exists
	  */
	  
	 boolean addBook(String ISBN, String title, String author, String publisher, int publishingYear);
	 
	 /**
	     * Update the information of an existing book
	     * @param isbn the ISBN of the book to update
	     * @param title the new title of the book to update
	     * @param author the new author of the book to update
	     * @param publisher the new publisher of the book to update
	     * @param publishingYear the new publishing year of the book to update
	     * @return true if the book is updated, false if the book does not exist
	  */
	  
	 boolean updateBook(String ISBN, String title, String author, String publisher, int publishingYear);
	 
	 /**
	     * Remove a book from the catalog by title
	     * @param title the title of the book to remove
	     * @return true if the book is removed, false if the book does not exist
	 */
	  
	 boolean removeBook(String title);
	 
	 /**
	     * Get all books by a given publisher
	     * @param publisher the publisher of the books to get
	     * @return an ArrayList of Book objects by the given publisher
	  */
	  
	 ArrayList<Book> getBooksByPublisher(String publisher);
	 
	 /**
	     * Sort all the books based on title
	  */
	  
	 void sortByTitle();
	 
	 /**
	     * Save the book catalog to a file
	  */
	  
	 void save();
	  
}
