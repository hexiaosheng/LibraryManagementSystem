import com.dbs.command.*;
import com.dbs.entity.Library;
import com.dbs.entity.User;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * @author Jason He
 * @date 2023/12/7 12:00
 */
public class CommandTest {

    Library library=new Library();
    @Test
    public void Process(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //test user role and right,only admin can add & delete a book to library
        Library.userService.Register("Bob","password2", User.UserType.user);
        Library.userService.Login("Bob","password2");
        outContent.reset();

        CmdBookAdd cmdBookAdd=new CmdBookAdd();
        cmdBookAdd.Process();
        assertThat(outContent.toString(), containsString("Please login in admin."));
        outContent.reset();

        CmdBookDelete cmdBookDelete=new CmdBookDelete();
        cmdBookDelete.Process();
        assertThat(outContent.toString(), containsString("Please login in admin."));
        outContent.reset();

        //test that there is user login first before borrow,search,return and list
        Library.userService.setUserList(new ArrayList<User>());
        CmdBookBorrow cmdBookBorrow=new CmdBookBorrow();
        cmdBookBorrow.Process();
        assertThat(outContent.toString(), containsString("Please login first."));
        outContent.reset();

        CmdBookList cmdBookList=new CmdBookList();
        cmdBookList.Process();
        assertThat(outContent.toString(), containsString("Please login first."));
        outContent.reset();

        CmdBookSearch cmdBookSearch=new CmdBookSearch();
        cmdBookList.Process();
        assertThat(outContent.toString(), containsString("Please login first."));
        outContent.reset();

        CmdBookReturn cmdBookReturn=new CmdBookReturn();
        cmdBookList.Process();
        assertThat(outContent.toString(), containsString("Please login first."));
        outContent.reset();
    }
}
