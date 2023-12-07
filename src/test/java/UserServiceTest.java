import com.dbs.entity.Library;
import com.dbs.entity.User;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Jason He
 * @date 2023/12/7 10:01
 */
public class UserServiceTest {

    Library library=new Library();

    @Test
    public void Register(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //test admin register
        Library.userService.Register("Alice","password1", User.UserType.admin);
        assertThat(outContent.toString(),containsString("admin Alice successfully registered."));
        outContent.reset();

        //test user register
        Library.userService.Register("Bob","password2", User.UserType.user);
        assertThat(outContent.toString(),containsString("user Bob successfully registered."));
        outContent.reset();

        //test user register without empty name
        Library.userService.Register("","password2", User.UserType.user);
        assertThat(outContent.toString(),containsString("User name can't be empty!"));
        outContent.reset();

        //test user register without empty password
        Library.userService.Register("Bob","", User.UserType.user);
        assertThat(outContent.toString(),containsString("User Password can't be empty!"));
        outContent.reset();

        //test user register without duplicate name
        Library.userService.Register("Bob","password2", User.UserType.user);
        assertThat(outContent.toString(),containsString("User name has been registered."));
        outContent.reset();
    }

    @Test
    public void Login(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Library.userService.Register("Alice","password1", User.UserType.admin);
        Library.userService.Register("Bob","password2", User.UserType.user);
        outContent.reset();

        //test admin login
        Library.userService.Login("Alice","password1");
        assertThat(outContent.toString(),containsString("admin Alice successfully logged in."));
        outContent.reset();

        //test user login
        Library.userService.Login("Bob","password2");
        assertThat(outContent.toString(),containsString("user Bob successfully logged in."));
        outContent.reset();

        //test user login with wrong password
        Library.userService.Login("Bob","password3");
        assertThat(outContent.toString(),containsString("Invalid user name or password."));
        outContent.reset();
    }

}
