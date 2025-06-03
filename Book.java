import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class represents a generic book in the library. 
 * It includes attributes and methods for managing book data such as code, title, author, genre, and quantity.
 * Student Name: Chloe Capriotti
 * Student Number: 041154964      
 * Section #: 301   
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */
public class Book {
	protected int bookCode;
	protected String title;
	protected String author;
	protected String genre;
	protected int quantityInStock;	
	private int maxQuantity; // original quantity, used to check if a book can be returned
	
	/**Default constructor initializing all fields to default values*/
	public Book(){
		this.bookCode = 0;
		this.title = "";
		this.author = "";
		this.genre = "";
		this.quantityInStock = 0;
		this.maxQuantity = 0; //initilizes to 0 to match quantity
	}
	
	/**Updates the quantity of the book.
	 * Ensures the quantity stays between 0 and max(original quantity).
	 * @param amount the number of books to add or subtract
	 * @return true if update is successful, false if it would result in invalid quantity*/
	public boolean updateQuantity(int amount) {
	    // Calculate what the new quantity would be after adding/subtracting
	    int newQuantityInStock = quantityInStock + amount;
	    // Prevent quantity from going below 0 (can't have negative stock)
	    if (newQuantityInStock < 0) {
	        return false;
	    }
	    // Prevent quantity from exceeding the original maximum allowed
	    if (newQuantityInStock > maxQuantity) {
	        return false;
	    }
	    // If within valid range, update the actual stock quantity
	    quantityInStock = newQuantityInStock;
	    return true;
	}
	
	/**Compares this book to another book
	 * @param book - the book to compare with
	 * @return true if titles and authors match or book codes are equal, false otherwise*/
	public boolean isEqual(Book book){
		if (this.bookCode == book.bookCode) {
			System.out.println("This book code already exists in the catalog.");
		}
		return (this.title.equalsIgnoreCase(book.title) && this.author.equalsIgnoreCase(book.author)) || (this.bookCode == book.bookCode);
	}
	
	/**Adds a new book by prompting the user for all required input
	 * @param scanner Scanner object for user input
	 * @return true if book was added successfully*/
	public boolean addBook(Scanner scanner){
		inputCode(scanner);
	    while(true) {
	    	//asks user for title, if null the author is set to "None"
			System.out.print("Enter the title of the book: ");
		    title = scanner.nextLine();
		    if (title.trim().isEmpty()) {
		    	System.out.println("Cannot have no title.");
		    	continue;
		    } else {
		    	break;
		    }
	    }
	    
	    //asks user for author, if null the author is set to "None"
	    System.out.print("Enter the author of the book: ");
	    author = scanner.nextLine();
	    if (author.trim().isEmpty()) {
	    	author = "None";
	    }
	    
	    //makes sure the quantity in stock is higher than 0 and int
	    quantityInStock = 0;
	    while (quantityInStock <= 0) {
	        System.out.print("Enter the quantity of the book: ");
	        try {
	            quantityInStock = scanner.nextInt();
	            if (quantityInStock <= 0) {
	                System.out.println("Invalid input");
	                quantityInStock = 0;
	                scanner.nextLine();
	            } else {
	                maxQuantity = quantityInStock; // sets the max quantity to the current quantity(for borrowing and returning books)
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid quantity");
	            quantityInStock = 0;
	            scanner.nextLine();
	        }
	    }
	    return true;
	}
	
	/**Prompts the user to enter a valid book code
	 * @param scanner Scanner object for user input
	 * @return true when a valid code is successfully entered*/
	public boolean inputCode(Scanner scanner) {
		while(true) {
			//asks user for a book code
			System.out.print("Enter the code for the book: ");
			try {
				bookCode = scanner.nextInt();
				scanner.nextLine();
				return true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid entry");
				scanner.nextLine();
			}
	}
}
	/**Returns a string representation of the book details
	 * @return formatted string with book information*/
	@Override
	public String toString(){
		return "Book: " + bookCode + " " + title + " " + quantityInStock + " Author: " + author + " Genre: " + genre;
		
	}
}
