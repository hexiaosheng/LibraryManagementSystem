import com.dbs.entity.Library;
import com.dbs.entity.User;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * @author Jason He
 * @date 2023/12/6 17:42
 */
public class BookServiceTest {

    Library library=new Library();
    @Test
    public void showBookList(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Library.userService.Register("Alice","password1", User.UserType.admin);

        Library.userBookService.showBookList();
        assertThat(outContent.toString(), containsString(""));
        outContent.reset();


        assertThat(outContent.toString(), containsString(""));
        outContent.reset();
    }

    @Test
    public void searchBook(String bookName,String bookAuthor){

    }
}
