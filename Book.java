//Evan Phillips
//Book class

package assg66_Phillipsev20;

public class Book implements Comparable<Book> {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int publishingYear;

   /**
    * 5 parameter constructor
    * @param isbn
    * @param title
    * @param author
    * @param publisher
    * @param publishingYear
    */
    public Book(String isbn, String title, String author, String publisher, int publishingYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
    }

    /**
     * get method for Isbn
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * get method for Title
     * @return title
     */
    public String getTitle() {
        return title;
    }
    /**
     * get method for Author
     * @return author
     */
    public String getAuthor() {
        return author;
    }
    /**
     * get method for publisher
     * @return publisher
     */
    public String getPublisher() {
        return publisher;
    }
    /**
     * get method for publishing year
     * @return publishingYear
     */
    public int getPublishingYear() {
        return publishingYear;
    }

    /**
     * set method for isbn
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * set method for author
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * set method for publisher
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    /**
     * set method for publishing year
     * @param publishingYear
     */
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    /**
     * To string method to print 
     */
    @Override
    public String toString() {
        return "ISBN: " + isbn + "\nTitle: " + title + "\nAuthor: " + author + "\nPublisher: " + publisher
                + "\nPublishing Year: " + publishingYear;
    }

    /**
	 * checks if the objects are the same
	 */
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book book = (Book) obj;
        return this.title.equals(book.title);
    }

    /**
     * Compares this book with another book based on their titles.
    @param book the book to be compared with
    @return a negative integer, zero, or a positive integer as this book is less than, equal to, or greater than the specified book
    */
    
    @Override
    public int compareTo(Book book) {
        return this.title.compareTo(book.title);
    }
}