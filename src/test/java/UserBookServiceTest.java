import com.dbs.entity.Library;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * @author Jason He
 * @date 2023/12/7 10:47
 */
public class UserBookServiceTest {
    Library library=new Library();

    @Test
    public void borrowBook(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Library.adminBookService.addBook("Clean Code","Robert C. Martin",5);
        outContent.reset();

        //borrow a book without book name
        Library.userBookService.borrowBook("","Robert C. Martin");
        assertThat(outContent.toString(), containsString("Book name can't be empty!"));
        outContent.reset();

        //borrow a book without book author
        Library.userBookService.borrowBook("Clean Code","");
        assertThat(outContent.toString(), containsString("Book author can't be empty!"));
        outContent.reset();

        //borrow a not exist book
        Library.userBookService.borrowBook("Clean Code1","Robert C. Martin");
        assertThat(outContent.toString(), containsString("No such book for borrow."));
        outContent.reset();

        //borrow a book successfully
        Library.userBookService.borrowBook("Clean Code","Robert C. Martin");
        assertThat(outContent.toString(), containsString("Book Clean Code successfully borrowed."));
        outContent.reset();

        //borrow a book which has been borrowed
        Library.userBookService.borrowBook("Clean Code","Robert C. Martin");
        assertThat(outContent.toString(), containsString("Book Clean Code has been borrowed."));
        outContent.reset();
    }


    @Test
    public void returnBook(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Library.adminBookService.addBook("Clean Code","Robert C. Martin",5);
        Library.userBookService.borrowBook("Clean Code","Robert C. Martin");
        outContent.reset();

        //return a book without book name
        Library.userBookService.returnBook("","Robert C. Martin");
        assertThat(outContent.toString(), containsString("Book name can't be empty!"));
        outContent.reset();

        //return a book without book author
        Library.userBookService.returnBook("Clean Code","");
        assertThat(outContent.toString(), containsString("Book author can't be empty!"));
        outContent.reset();

        //return a not existed book
        Library.userBookService.returnBook("Clean Code1","Robert C. Martin");
        assertThat(outContent.toString(), containsString("No such book for return."));
        outContent.reset();

        //return a book
        Library.userBookService.returnBook("Clean Code","Robert C. Martin");
        assertThat(outContent.toString(), containsString("Book Clean Code successfully returned."));
        outContent.reset();

        //return a book which is already been returned
        Library.userBookService.returnBook("Clean Code","Robert C. Martin");
        assertThat(outContent.toString(), containsString("Book Clean Code is already returned."));
        outContent.reset();
    }
}
