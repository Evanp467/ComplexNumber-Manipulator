//Evan Phillips
//Library application class
package assg66_Phillipsev20;

import java.io.*;
import java.util.*;

public class LibraryApplication {
    
    public static void main(String[] args) {
        BookCatalogInterface catalog = new BookCatalog("assg6_catalog.txt");
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
       
        String filename = "assg6_catalog.txt";
        File file = new File(filename);
        if (file.exists()) {
            catalog.loadData(filename);
            System.out.println("Data loaded from file.");
        } else {
            System.out.println("File not found. Starting with empty catalog.");
        }
        
        while (!exit) {
            System.out.println("===========");
            System.out.println("MAIN MENU");
            System.out.println("===========");
            System.out.println("1. Display all the books in the catalog");
            System.out.println("2. Search for a book");
            System.out.println("3. Add a new book");
            System.out.println("4. Update an existing book");
            System.out.println("5. Remove a book");
            System.out.println("6. Display books by a publisher");
            System.out.println("7. Sort all the books based on title");
            System.out.println("8. Save data");
            System.out.println("9. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    catalog.displayCatalog();
                    break;
                case 2:
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    Book searchResult = catalog.searchForBook(title);
                    if (searchResult != null) {
                        System.out.println(searchResult);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter the title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter the author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter the publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter the publishing year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    boolean addResult = catalog.addBook(isbn, newTitle, author, publisher, year);
                    if (addResult) {
                        System.out.println("Book added.");
                    } else {
                        System.out.println("Book already exists.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the title of the book to update: ");
                    String updateTitle = scanner.nextLine();
                    Book updateBook = catalog.searchForBook(updateTitle);
                    if (updateBook != null) {
                        System.out.print("Enter the new ISBN: ");
                        String newIsbn = scanner.nextLine();
                        System.out.print("Enter the new author: ");
                        String newAuthor = scanner.nextLine();
                        System.out.print("Enter the new publisher: ");
                        String newPublisher = scanner.nextLine();
                        System.out.print("Enter the new publishing year: ");
                        int newYear = scanner.nextInt();
                        scanner.nextLine();
                        boolean updateResult = catalog.updateBook(newIsbn, updateTitle, newAuthor, newPublisher, newYear);
                        if (updateResult) {
                            System.out.println("Book updated.");
                        } else {
                            System.out.println("Failed to update book.");
                        }
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the title of the book to remove: ");
                    String delTitle = scanner.nextLine();
                    if (catalog.removeBook(delTitle)) {
                    	System.out.println("Book was removed.");
                    }
                    else {
                    	System.out.println("Book was not removed.");
                    }
                    break;
                
                case 6:
                	System.out.print("Please enter a publisher: ");
                	String srchPublisher = scanner.nextLine();
                	ArrayList<Book> publisherBooks = catalog.getBooksByPublisher(srchPublisher);
                	if (publisherBooks.size() == 0) {
                		System.out.println("No books by publisher.");
                	}
                	else {
                		publisherBooks.forEach(book -> System.out.println(book.toString()));
                	}
                	break;
                	
                case 7:
                	catalog.sortByTitle();
                	System.out.println("Books Sorted.");
                	break;
                
                case 8:
                	catalog.save();
                	System.out.println("Books Saved.");
                	break;
                
                case 9:
                	catalog.save();
                	System.out.println("Bye!");
                	scanner.close();
                	System.exit(0);
                	break;
            	}
        	}
    	}
	}	
