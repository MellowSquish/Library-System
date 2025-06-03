import java.util.Scanner;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class defines a FictionBook, the genre of a book. It inherits properties from the Book class 
 * and initializes genre.  
 * Student Name: Chloe Capriotti
 * Student Number: 041154964      
 * Section #: 301   
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */
public class FictionBook extends Book{
	protected String genre;
	
	/**FictionBook No argument constructor, calls super, sets genre*/
	FictionBook(){
		super();
		super.genre = "Fiction";
	}
	
	/**calls the add book method from super
	 * @param scanner for user input
	 * @return boolean for if method worked*/
	public boolean addBook(Scanner scanner){
		super.addBook(scanner);
		return true;
	}
	
	/**Returns a string of a Fiction book
	 * @return formatted string with book details - called from super class*/
	@Override
	public String toString() {
		return super.toString();
	}
}
