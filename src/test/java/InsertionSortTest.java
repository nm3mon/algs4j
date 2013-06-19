import org.junit.Assert;
import org.junit.Test;

/**
 * @author Nabeel Ali Memon
 */
public class InsertionSortTest {
  @Test public void testInsertionSort() {
    for (int loop = 0; loop < 100; loop++) { //taking 100 samples
      int[] input = new int[100];
      for (int i = 0; i < 100; i++) {
        input[i] = StdRandom.uniform(100);
      }
      StdArrayIO.print(input);
      System.out.println("===============");
      InsertionSort.sort(input);
      StdArrayIO.print(input);
      for (int i = 1; i < input.length; i++) {
        Assert.assertTrue(input[i - 1] <= input[i]);
      }
    }
  }
}
