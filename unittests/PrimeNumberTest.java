/**
 * Created by Timothy on 6/25/2015.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import com.regant.PrimeNumberGen;
import java.util.*;

public class PrimeNumberTest {

    PrimeNumberGen generator;

    @Before
    public void setUp() {
        generator = new PrimeNumberGen();
    }

    @Test
    public void PrimeNumbersFrom1to10(){
        List<Integer> actualPrimes = generator.generate(1, 10);
        List<Integer> expectedPrimes = new ArrayList<>();
        expectedPrimes.add(1);
        expectedPrimes.add(2);
        expectedPrimes.add(3);
        expectedPrimes.add(5);
        expectedPrimes.add(7);

        assertEquals(expectedPrimes,actualPrimes);
    }

    @Test
    public void PrimeNumbersFrom1to5(){
        List<Integer> actualPrimes = generator.generate(1, 5);
        List<Integer> expectedPrimes = new ArrayList<>();
        expectedPrimes.add(1);
        expectedPrimes.add(2);
        expectedPrimes.add(3);
        expectedPrimes.add(5);

        assertEquals(expectedPrimes,actualPrimes);
    }

    @Test
    public void PrimeNumbersFrom7900to7920(){
        List<Integer> actualPrimes = generator.generate(7900, 7920);
        List<Integer> expectedPrimes = new ArrayList<>();
        expectedPrimes.add(7901);
        expectedPrimes.add(7907);
        expectedPrimes.add(7919);

        assertEquals(expectedPrimes,actualPrimes);
    }

    @Test
    public void NoPrimesInRange(){
        List<Integer> actualPrimes = generator.generate(1002, 1004);
        List<Integer> expectedPrimes = new ArrayList<>();

        assertEquals(expectedPrimes,actualPrimes);
    }

    @Test
    public void PrimeNumbersFromNegativeNumberTo10(){
        List<Integer> actualPrimes = generator.generate(-10, 10);
        List<Integer> expectedPrimes = new ArrayList<>();
        expectedPrimes.add(1);
        expectedPrimes.add(2);
        expectedPrimes.add(3);
        expectedPrimes.add(5);
        expectedPrimes.add(7);

        assertEquals(expectedPrimes,actualPrimes);
    }

    @Test
    public void PrimeNumbersFrom10to1(){
        List<Integer> actualPrimes = generator.generate(10, 1);
        List<Integer> expectedPrimes = new ArrayList<>();
        expectedPrimes.add(1);
        expectedPrimes.add(2);
        expectedPrimes.add(3);
        expectedPrimes.add(5);
        expectedPrimes.add(7);

        assertEquals(expectedPrimes,actualPrimes);
    }

    @Test
    public void NumberIsPrime(){
        assertTrue(generator.isPrime(1));
        assertTrue(generator.isPrime(3));
        assertTrue(generator.isPrime(5));
        assertTrue(generator.isPrime(13));
        assertTrue(generator.isPrime(101));
    }

    @Test
    public void NumberNotPrime() {
        assertFalse(generator.isPrime(4));
        assertFalse(generator.isPrime(9));
        assertFalse(generator.isPrime(15));
        assertFalse(generator.isPrime(112));
        assertFalse(generator.isPrime(999));
    }

    @Test
    public void ZeroOrLessNotPrime(){
        assertFalse(generator.isPrime(0));
        assertFalse(generator.isPrime(-1));
        assertFalse(generator.isPrime(-7));
    }
}
