package dil.random;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

// Helpful functions that can be imported elsewhere to use since they are static
public class MyUtils {
    /**
     *
     * @param min
     * @param max
     * @return random int between min and max, inclusive of both
     */
    public static int getRandomInt(int min, int max) {
        Random rand = new Random();
        return (rand.nextInt(max - min + 1) + min);
    }

    /**
     *
     * @param arr any array
     * @return
     * @param <T> a random index (int) of the array
     */
    public static <T> int getRandomIndex(T[] arr) {
        return getRandomInt(0, arr.length - 1);
    }

    /**
     * takes 2 arrays of the same type and concatenates (combines) them into a new array
     * @param arr1 first array
     * @param arr2 second array (same type as first)
     * @return
     * @param <T> concatenated array
     */
    public static <T> T[] concatentateArrays(T[] arr1, T[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int concatLength = length1 + length2;

        // Create a new array with the combined length
        T[] concatenatedArray = (T[]) Array.newInstance(arr1.getClass().getComponentType(), concatLength);

        // Copy the elements from both arrays into the new array
        System.arraycopy(arr1, 0, concatenatedArray, 0, length1);
        System.arraycopy(arr2, 0, concatenatedArray, length1, length2);

        return concatenatedArray;
    }

    /**
     * Increase the odds of something getting picked by adding it to the arrDuplicates arrays. This basically chooses from a combined array of the 2 inputted while keeping the original index. Example: suppose you have 2 items "a" and "b". getRandomIndex of array of {"a", "b"} returns equal odds for a and b, but you want a to be twice as likely. getRandomIndex of array of {"a", "a", "b"} achieves this but now b's index is wrong. Use getRandomIndexOddsIncrease({"a", "b"}, {"a"}) to achieve a being twice as likely, but you still get index of 1 for a and 2 for b.
     * @param arr original list of item
     * @param arrDuplicates the items you want to increase
     * @return
     * @param <T> the index of the item from the original list
     */
    public static <T> int getRandomIndexOddsIncrease(T[] arr, T[] arrDuplicates) {
        T[] arrOddsIncreased = concatentateArrays(arr, arrDuplicates);
        // Get an item based on those odds
        int oddsIndex = getRandomIndex(arrOddsIncreased);
        T item = arrOddsIncreased[oddsIndex];
        int originalArrIndex = Arrays.asList(arr).indexOf(item); // binarySearch didn't work
        return originalArrIndex;
    }
}
