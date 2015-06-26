import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.regant.PrimeNumberGen;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Timothy on 6/25/2015.
 */
public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanup(){
        System.setOut(null);
    }

    @Test
    public void MainInterface1To10(){
        String[] args = {"1", "10"};
        PrimeNumberGen.main(args);
        assertEquals("There are 5 prime numbers between 1 and 10:\r\n" +
                "[1, 2, 3, 5, 7]\r\n", outContent.toString());
    }

    @Test
    public void MainInterfaceNoPrimes(){
        String[] args = {"1002", "1004"};
        PrimeNumberGen.main(args);
        assertEquals("There are 0 prime numbers between 1002 and 1004:\r\n" +
                "[]\r\n", outContent.toString());
    }

    @Test
    public void MainInterfaceInvalidArgumentFirst(){
        String[] args = {"Bob", "10"};
        PrimeNumberGen.main(args);
        assertEquals("Invalid argument Bob. Arguments must be whole numbers\r\n", outContent.toString());
    }

    @Test
    public void MainInterfaceInvalidArgumentSecond(){
        String[] args = {"1", "Robert"};
        PrimeNumberGen.main(args);
        assertEquals("Invalid argument Robert. Arguments must be whole numbers\r\n", outContent.toString());
    }

    @Test
    public void MainInterfaceNoArguments(){
        String[] args = {};
        PrimeNumberGen.main(args);
        assertEquals("usage: com.regant.PrimeNumberGen startingValue endingValue\r\n", outContent.toString());
    }
}
