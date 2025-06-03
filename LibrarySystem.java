import java.util.*;
import java.util.Scanner;
/**
 * This class contains the main menu system and entry point for the Library Management System.  
 * It allows users to add books, display the catalog, borrow and return books.
 */
public class LibrarySystem {
	/**Displays the main menu options for the user to choose from.*/
	static void displayMenu(){
		System.out.print("Please select one of the following: \n"
						 + "1: Add Book to Library \n"
						 + "2: Display Current Library Catalog \n"
						 + "3: Borrow Book(s) \n"
						 + "4: Return Book(s) \n"
						 + "5: To Exit \n"
						 + "> ");
	}
	/**Main method that runs the menu loop for user interaction.
	 * @param args Command line arguments*/
	public static void main (String[] args) {
		//objects for scanner and library
		Scanner scanner = new Scanner(System.in);
		Library library = new Library();
		int choice; //variable to choose something in the menu
		while(true) {
			displayMenu();
			//checks that user input is a valid number
			try {
				choice = scanner.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("...Invalid input, please try again...");
				scanner.nextLine();
				continue;
			}
			switch(choice) {
			//checks for exiting first in case statement
			case 5:
				System.out.println("Exiting...");
				System.exit(0);
			//adds a book to library
			case 1:
				library.addBook(scanner);
				break;
			//prints out an appended string of all the books
			case 2:
				System.out.println(library.toString());
				break;
			//lets you borrow a book from the library
			case 3:
				library.borrowBook(scanner);
				break;
			//lets you return a book from the library
			case 4:
				library.returnBook(scanner);
				break;
			//invalid input for anything thats not 1-5
			default:
				System.out.println("...Invalid input, please try again...");
				break;
			}
		}
	}
}
