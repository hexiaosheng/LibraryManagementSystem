import com.dbs.entity.Library;
import com.dbs.entity.User;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * @author Jason He
 * @date 2023/12/7 10:47
 */
public class AdminBookServiceTest {
    Library library=new Library();

    @Test
    public void  addBook(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //test add book
        Library.adminBookService.addBook("Clean Code","Robert C. Martin",5);
        assertThat(outContent.toString(),
                containsString("Book Clean Code by Robert C. Martin added successfully, inventory: 5."));
        outContent.reset();

        //test add book with empty book name
        Library.adminBookService.addBook("","Robert C. Martin",5);
        assertThat(outContent.toString(),
                containsString("Book name can't be empty!"));
        outContent.reset();

        //test add book with empty book author
        Library.adminBookService.addBook("Clean Code","",5);
        assertThat(outContent.toString(),
                containsString("Book author can't be empty!"));
        outContent.reset();

        //test add book with invalid book inventory
        Library.adminBookService.addBook("Clean Code","Robert C. Martin",0);
        assertThat(outContent.toString(),
                containsString("Book inventory must larger than 0!"));
        outContent.reset();

        //test add an exist book with different book inventory
        Library.adminBookService.addBook("Clean Code","Robert C. Martin",3);
        assertThat(outContent.toString(),
                containsString("Book Clean Code inventory successfully updated, new inventory: 8"));
        outContent.reset();
    }

    @Test
    public void  deleteBook(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Library.adminBookService.addBook("Clean Code","Robert C. Martin",5);
        outContent.reset();

        //delete a book without book name
        Library.adminBookService.deleteBook("","Robert C. Martin");
        assertThat(outContent.toString(), containsString("Book name can't be empty!"));
        outContent.reset();

        //delete a book without book author
        Library.adminBookService.deleteBook("Clean Code","");
        assertThat(outContent.toString(), containsString("Book author can't be empty!"));
        outContent.reset();

        //delete a not existed book
        Library.adminBookService.deleteBook("Clean Code1","Robert C. Martin");
        assertThat(outContent.toString(), containsString("No such book for deletion."));
        outContent.reset();

        //delete a book which has been borrowed
        Library.userBookService.borrowBook("Clean Code","Robert C. Martin");
        outContent.reset();
        Library.adminBookService.deleteBook("Clean Code","Robert C. Martin");
        assertThat(outContent.toString(), containsString("Cannot delete book Clean Code because it is currently borrowed."));
        Library.userBookService.returnBook("Clean Code","Robert C. Martin");
        outContent.reset();

        //delete a book
        Library.adminBookService.deleteBook("Clean Code","Robert C. Martin");
        assertThat(outContent.toString(), containsString("Book Clean Code by Robert C. Martin deleted successfully."));
        outContent.reset();
    }
}
