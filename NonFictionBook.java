import java.util.*;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class defines a NonFictionBook, the genre of a book. It inherits properties from the Book class 
 * and initializes genre. 
 * Student Name: Chloe Capriotti
 * Student Number: 041154964      
 * Section #: 301   
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */
public class NonFictionBook extends Book{
	@SuppressWarnings("unused")
	private String genre;
	private String fieldOfStudy; // gets the field of study of a non-fiction book
	
	/**NonFictionBook No argument constructor, calls super, sets genre*/
	NonFictionBook(){
		super();
		super.genre = "NonFiction";
	}
	
	/**calls the add book method from super and asks for field of study
	 * @param scanner for user input
	 * @return boolean for if method worked*/
	public boolean addBook(Scanner scanner){
	    super.addBook(scanner);
	    scanner.nextLine();
	    System.out.print("Enter the field of study for book: ");
	    fieldOfStudy = scanner.nextLine();
		return true;
	}
	
	/**
	 * Returns a string of a Non - Fiction book
	 * @return formatted string with book details - called from super class - with added field of study
	 */
	@Override
	public String toString() {
		return super.toString() + " Field of Study: " + fieldOfStudy;
	}
}
