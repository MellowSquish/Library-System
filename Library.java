import java.util.*;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains methods to manage a library of books including adding, borrowing, and returning books.
 * Student Name: Chloe Capriotti
 * Student Number: 041154964      
 * Section #: 301   
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */
public class Library {
	private Book[] catalog = new Book[20];
	private int numBooks;

	/** Constructor initializes the book count to 0 */
	public Library() {
		this.numBooks = 0;
	}

	/**
	 * Checks if a given book already exists in the catalog
	 * @param book - Book to check
	 * @return index if exists, -1 otherwise
	 */
	public int alreadyExists(Book book) {
		//checks the catalog and sees if the book is equal to another book(same author+title or same book code)
		for (int i = 0; i < numBooks; i++) {
			if (catalog[i].isEqual(book)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Adds a new book to the catalog through user input for book details
	 * @param scanner - Scanner object for input
	 * @return true if successfully added, false otherwise
	 */
	public boolean addBook(Scanner scanner) {
		//checks if the number of books created is over the 20 limit of the array
	    if (numBooks >= catalog.length) {
	        System.out.println("Library is full. Cannot add more books.");
	        return false;
	    }
	    Book book = null;
	    while (true) {
	    	//asks for the genre of the book through a case statement
	        System.out.print("Do you wish to add a Fiction(f), Non-Fiction(n), or Reference(r) book? ");
	        String genreType = scanner.next().toLowerCase();
	        scanner.nextLine();
	        switch (genreType) {
	            //genre = fiction
	        	case "f":
	                book = new FictionBook();
	                break;
	            //genre = nonfiction
	            case "n":
	                book = new NonFictionBook();
	                break;
	            //genre = reference
	            case "r":
	                book = new ReferenceBook();
	                break;
	            //not a valid genre entry - loops back
	            default:
	                System.out.println("Invalid entry");
	                continue;
	        }
	    break; // breaks out of loop if successful
	    }
	  //checks if the book already exists
	    book.addBook(scanner);
	    if (alreadyExists(book) != -1) {
	        System.out.println("Book is already in catalog");
	        return false;
	    }
	    //adds the book if the book has not already been added into the catalog
	    catalog[numBooks++] = book;
	    System.out.println("Book added successfully");
	    return true;
	}
	
	/**Attempts to borrow a book by code
	 * Decreases the quantity of the book if possible
	 * @param scanner Scanner object for input
	 * @return true if the book is successfully borrowed, false otherwise*/
	public boolean borrowBook(Scanner scanner) {
	    // Checks if the catalog is empty
	    if (numBooks == 0) {
	        System.out.println("Error...could not borrow book");
	        return false;
	    }
	    // Prompt user to enter a book code to borrow
	    System.out.print("Enter valid book code to borrow: ");
	    int borrowCode; // a value to compare book codes with to find what user wants
	    int borrowQuantity; // a value to compare total quantity to see if user can borrow that many
	    try {
	        borrowCode = scanner.nextInt();
	        scanner.nextLine();
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid code");
	        scanner.nextLine();
	        return false;
	    }
	    //checks if user gives an int for quantity to borrow
	    System.out.print("Enter a valid quantity to borrow: ");
	    try {
	        borrowQuantity = scanner.nextInt();
	        scanner.nextLine();
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid quantity");
	        scanner.nextLine();
	        return false;
	    }
	    // Search the catalog for a book with the matching code
	    for (int i = 0; i < numBooks; i++) {
	        if (catalog[i].bookCode == borrowCode) {
	        	// Prevent returning if the book is a ReferenceBook
	            if (catalog[i] instanceof ReferenceBook) {
	                System.out.println("Error...can not borrow a Reference book");
	                return false;
	            }
	            //checks if there are enough books to borrow
	            if (catalog[i].quantityInStock < borrowQuantity) {
	            	System.out.println("Error... Trying to return more than checkout quantity");
	                return false;
	            }
	            // Attempt to decrease quantity by 1 (borrow)
	            if (catalog[i].updateQuantity(-borrowQuantity)) {
	                System.out.println("Book borrowed successfully\n");
	                return true;
	            } else {
	                // Quantity could not be updated
	                System.out.println("Error...could not borrow book");
	                return false;
	            }
	        }
	    }

	    // No book found
	    System.out.println("Error...could not borrow book");
	    return false;
	}

	/**Attempts to return a book by code
	 * Increases the quantity of the book if possible
	 * @param scanner Scanner object for input
	 * @return true if the book is successfully returned, false otherwise*/
	public boolean returnBook(Scanner scanner) {
	    // Check if the catalog is empty
	    if (numBooks == 0) {
	        System.out.println("Error...could not return book");
	        return false;
	    }

	    // Prompt user to enter a book code to return
	    System.out.print("Enter valid book code to return: ");
	    int returnCode; // a value to compare book codes with to find what user wants
	    int returnQuantity; // a value to compare total quantity to see if user can return that many
	    try {
	        returnCode = scanner.nextInt();  
	        scanner.nextLine(); 
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid entry"); 
	        scanner.nextLine(); 
	        return false;
	    }
	    //checks if user gives an int for quantity to return
	    System.out.print("Enter a valid quantity to return: ");
	    try {
	        returnQuantity = scanner.nextInt();
	        scanner.nextLine();
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid quantity");
	        scanner.nextLine();
	        return false;
	    }

	    // Search the catalog for a book with the matching code
	    for (int i = 0; i < numBooks; i++) {
	        if (catalog[i].bookCode == returnCode) {
	        	// Prevent returning if the book is a ReferenceBook
	            if (catalog[i] instanceof ReferenceBook) {
	                System.out.println("Error...can not return a Reference book");
	                return false;
	            }
	            //checks if there are enough books to return
	            if (catalog[i].quantityInStock < returnQuantity) {
	            	System.out.println("Error... Trying to borrow more than checkout quantity");
	                return false;
	            }
	            // Attempt to increase quantity by 1 (return)
	            if (catalog[i].updateQuantity(+returnQuantity)) {
	                System.out.println("Book returned successfully\n");
	                return true;
	            } else {
	                // Return failed because the book is already at max stock
	                System.out.println("Error...could not return book, none borrowed");
	                return false;
	            }
	        }
	    }

	    // No book found
	    System.out.println("Book not found in the catalog.");
	    return false;
	}
	
	/**Returns the catalog as a formatted string
	 * @return String of all books in the catalog*/
	@Override
	public String toString() {
	    String libraryString = ""; // appends a string of the catalog array to show the books in the library
	    System.out.println("Library Catalog: ");
	    //goes through the catalog to print each element
	    for (int i = 0; i < numBooks; i++) {
	       libraryString += catalog[i].toString() + "\n";
	    }
	    return libraryString;
	}
}