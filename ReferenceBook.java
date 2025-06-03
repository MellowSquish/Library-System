import java.util.*;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class defines a ReferenceBook, the genre of a book. It inherits properties from the Book class 
 * and initializes genre.
 * Student Name: Chloe Capriotti
 * Student Number: 041154964      
 * Section #: 301   
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */
public class ReferenceBook extends Book{
	protected String genre;
	private String referenceEdition; // gets the edition of a reference book
	
	/**ReferenceBook No argument constructor, calls super, sets genre*/
	ReferenceBook(){
		super();
		super.genre = "Reference";
	}
	
	/**calls the add book method from super and asks for reference edition
	 * @param scanner for user input
	 * @return boolean for if method worked*/
	public boolean addBook(Scanner scanner){
		super.addBook(scanner);
		scanner.nextLine();
		System.out.print("Enter the edition of the book: ");
	    referenceEdition = scanner.nextLine();
		return true;
	}
	
	/**
	 * Returns a string of a Reference book
	 * @return formatted string with book details - called from super class - with added reference edition
	 */
	@Override
	public String toString() {
	    return super.toString() + " Edition: " + referenceEdition;
	}
}