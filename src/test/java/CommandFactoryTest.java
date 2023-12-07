import com.dbs.command.Command;
import com.dbs.command.CommandFactory;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Jason He
 * @date 2023/12/7 12:00
 */
public class CommandFactoryTest {

    @Test
    public void  getInstance() throws Exception {

        //test valid command
        for(String key: CommandFactory.CmdAliasingClassName().keySet()){
            assertThat(CommandFactory.getInstance(key).getClass().getName().toString(),
                    equalTo(CommandFactory.CmdAliasingClassName().get(key)));
        }


        //test an invalid command which can't support
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        try {
            CommandFactory.getInstance("rent");
        } catch (Exception ex) {
            System.out.println("Invalid command,which system can't support");
        }
        outContent.reset();
    }
}
