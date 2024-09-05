package dil.random;

import org.junit.Test;

import static org.junit.Assert.*;
import static dil.random.MyUtils.getRandomIndexOddsIncrease;
import static dil.random.MyUtils.getRandomInt;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RandomUnitTest {
    // Run many times to get a more accurate percent
    public int timesToTestRandom = 1000;
    // Percentage off you can be by. So you can be off by 3%
    public double percentApproximately = .03;

    /**
     * is value approximately the expected one for percent
     * @param value
     * @param expected
     * @return
     */
    public boolean isApproximately(double value, double expected) {
        return value < expected + percentApproximately && value > expected - percentApproximately;
    }

    // Obviously these tests aren't great since we deal with randomness
    @Test
    public void getRandomIntTest() throws Exception {
        int one = 0;
        int two = 0;
        int three = 0;
        int other = 0;
        // Run function many times and keep track of how many times each number is generated
        for (int i =1; i <= timesToTestRandom; i++) {
            int num = getRandomInt(1, 3);
            if (num == 1) one++;
            else if (num == 2) two++;
            else if (num == 3) three++;
            else other++;
        }
        // Are numbers close to expected percent?
        assertTrue(isApproximately((double) one /timesToTestRandom, (double) 1 /3));
        assertTrue(isApproximately((double) two /timesToTestRandom, (double) 1 /3));
        assertTrue(isApproximately((double) three /timesToTestRandom, (double) 1 /3));
        assertTrue(other == 0);
    }

    @Test
    public void getRandomIndexOddsIncreasedTest() throws Exception {
        String[] arr = {"a", "b", "c"};
        String[] duplicate = {"b"};
        int zero = 0;
        int one = 0;
        int two = 0;
        int other = 0;
        // Run function many times and keep track of how many times each number is generated
        for (int i =1; i <= timesToTestRandom; i++) {
            int num = getRandomIndexOddsIncrease(arr, duplicate);
            if (num == 0) zero++;
            else if (num == 1) one++;
            else if (num == 2) two++;
            else other++;
        }
        // Are numbers close to expected percent?
        assertTrue(isApproximately((double) zero /timesToTestRandom, (double) 1 /4));
        assertTrue(isApproximately((double) one /timesToTestRandom, (double) 2 /4));
        assertTrue(isApproximately((double) two /timesToTestRandom, (double) 1 /4));
        assertTrue(other == 0);
    }
}