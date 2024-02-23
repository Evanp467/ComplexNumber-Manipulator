//Evan Phillips
//Book Catalog class
package assg66_Phillipsev20;

import java.io.*;
import java.util.*;

public class BookCatalog implements BookCatalogInterface {

    private ArrayList<Book> catalog;
    private boolean isDataChanged;
    private String fileName;
    
    public BookCatalog(String fileName) {
        this.catalog = new ArrayList<>();
        this.fileName = fileName;
    }
    
    /**
     * Load the data containing all the books from a given file
     * @param fileName the name of the file to load
     */
    
    @Override
    public void loadData(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String isbn = scanner.nextLine();
                String title = scanner.nextLine();
                String author = scanner.nextLine();
                String publisher = scanner.nextLine();
                int year = Integer.parseInt(scanner.nextLine());
                if(!scanner.hasNextLine())
                {
                	Book book = new Book(isbn, title, author, publisher, year);
                	catalog.add(book);
                	break;
                }
                
                scanner.nextLine();
                Book book = new Book(isbn, title, author, publisher, year);
                
                catalog.add(book);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid year format in data file");
        }
    }
    
    /**
     * Display all the books in the catalog
     */
	
    @Override
    public void displayCatalog() {
        if (catalog.size() == 0) {
            System.out.println("No books in catalog");
        } else {
            for (Book book : catalog) {
                System.out.println(book.toString());
            }
        }
    }
    
    /**
     * Search for a book by title
     * @param title the title of the book to search for
     * @return the Book object if found, or null if not found
     */
    
    @Override
    public Book searchForBook(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    
    /**
     * Add a new book to the catalog
     * @param isbn the ISBN of the book to add
     * @param title the title of the book to add
     * @param author the author of the book to add
     * @param publisher the publisher of the book to add
     * @param publishingYear the publishing year of the book to add
     * @return true if the book is added, false if the book already exists
     */

    @Override
    public boolean addBook(String isbn, String title, String author, String publisher, int year) {
        if (searchForBook(title) != null) {
            System.out.println("Book already exists in catalog");
            return false;
        } else {
            catalog.add(new Book(isbn, title, author, publisher, year));
            isDataChanged = true;
            return true;
        }
    }
    
    /**
     * Update the information of an existing book
     * @param isbn the ISBN of the book to update
     * @param title the new title of the book to update
     * @param author the new author of the book to update
     * @param publisher the new publisher of the book to update
     * @param publishingYear the new publishing year of the book to update
     * @return true if the book is updated, false if the book does not exist
     */

    @Override
    public boolean updateBook(String isbn, String title, String author, String publisher, int year) {
        Book bookToUpdate = searchForBook(title);
        if (bookToUpdate == null) {
            System.out.println("Book does not exist in catalog");
            return false;
        } else {
            bookToUpdate.setIsbn(isbn);
            bookToUpdate.setAuthor(author);
            bookToUpdate.setPublisher(publisher);
            bookToUpdate.setPublishingYear(year);
            isDataChanged = true;
            return true;
        }
    }
    
    /**
     * Remove a book from the catalog by title
     * @param title the title of the book to remove
     * @return true if the book is removed, false if the book does not exist
     */

    @Override
    public boolean removeBook(String title) {
        Book bookToRemove = searchForBook(title);
        if (bookToRemove == null) {
            System.out.println("Book does not exist in catalog");
            return false;
        } else {
            catalog.remove(bookToRemove);
            isDataChanged = true;
            return true;
        }
    }
    
    /**
     * Get all books by a given publisher
     * @param publisher the publisher of the books to get
     * @return an ArrayList of Book objects by the given publisher
     */

    @Override
    public ArrayList<Book> getBooksByPublisher(String publisher) {
        ArrayList<Book> booksByPublisher = new ArrayList<Book>();
        for (Book book : catalog) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                booksByPublisher.add(book);
            }
        }
        return booksByPublisher;
    }
    
    /**
     * Sort all the books based on title
     */

    @Override
    public void sortByTitle() {
        Collections.sort(catalog, new Comparator<Book>() {
            public int compare(Book book1, Book book2) {
                return book1.getTitle().compareToIgnoreCase(book2.getTitle());
            }
        });
        isDataChanged = true;
    }
    
    /**
     * Save the book catalog to a file
     */
  
    public void save() {
        if (isDataChanged) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                for (int i = 0; i<catalog.size(); i++) {
                	
                	if (i == catalog.size()-1) {
                		writer.write(String.format("%s\n", catalog.get(i).getIsbn()));
                    	writer.write(String.format("%s\n", catalog.get(i).getTitle()));
                    	writer.write(String.format("%s\n", catalog.get(i).getAuthor()));
                    	writer.write(String.format("%s\n", catalog.get(i).getPublisher()));
                    	writer.write(String.format("%d\n", catalog.get(i).getPublishingYear()));
                	}
                	else {
                	writer.write(String.format("%s\n", catalog.get(i).getIsbn()));
                	writer.write(String.format("%s\n", catalog.get(i).getTitle()));
                	writer.write(String.format("%s\n", catalog.get(i).getAuthor()));
                	writer.write(String.format("%s\n", catalog.get(i).getPublisher()));
                	writer.write(String.format("%d\n", catalog.get(i).getPublishingYear()));
                	writer.write(String.format("\n"));
                	}
                }
                
                
            } catch (IOException e) {
                System.out.println("Error while writing to file: " + e.getMessage());
            }
            isDataChanged = false;
        }
    }
}





