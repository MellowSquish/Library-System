import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains junit testing
 * Student Name: Chloe Capriotti
 * Student Number: 041154964      
 * Section #: 301   
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 */
public class Assign1Test {
	//initilizing library object
    private Library library;

    //makes a library object before each test
    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    /** tests that a book can be borrowed */
    @Test
    public void testBorrowFictionBookSuccess() {
    	//makes a test book to help simulate test
        Scanner addInput = new Scanner("f\n 001\n RandomTitle\n RandomAuthor\n 5\n");
        library.addBook(addInput);

        //borrowCode and number to borrow on one line
        Scanner borrowInput = new Scanner("001\n 2\n");
        assertTrue(library.borrowBook(borrowInput));
    }

    /** tests not being able to borrow more than in stock*/
    @Test
    public void testBorrowTooManyFictionFails() {
    	//makes a test book to help simulate test
        Scanner addInput = new Scanner("n\n 002\n AnotherRandomTitle\n AnotherRandomAuthor\n 1\n fieldofstudy\n");
        library.addBook(addInput);

        Scanner borrowInput = new Scanner("002\n 3\n");
        assertFalse(library.borrowBook(borrowInput));
    }
    /** tests that a book can be returned */
    @Test
    public void testReturnNonFictionBookSuccess() {
    	//makes a test book to help simulate test
        Scanner addInput = new Scanner("f\n 003\n AnotherAnotherRandomTitle\n AnotherAnotherRandomTitle\n 5\n");
        library.addBook(addInput);

      //borrowCode and number to borrow on one line
        library.borrowBook(new Scanner("003\n 1\n"));

        Scanner returnInput = new Scanner("003\n 1\n");
        assertTrue(library.returnBook(returnInput));
    }
    /** tests that a book can be returned */
    @Test
    public void testBorrowReferenceBookFail() {
    	//makes a test book to help simulate test
        Scanner addInput = new Scanner("r\n 004\n AnotherAnotherAnotherRandomTitle\n AnotherAnotherAnotherRandomAuthor\n 5\n 4th\n");
        library.addBook(addInput);

        //borrowCode and number to borrow on one line
        Scanner borrowInput = new Scanner("004\n 2\n");
        assertFalse(library.borrowBook(borrowInput));
    }
}