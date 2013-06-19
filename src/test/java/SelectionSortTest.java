import org.junit.*;

/**
 * @author Nabeel Ali Memon
 */
public class SelectionSortTest {
  @Test public void testSelectionSort2() {
    for (int loop = 0; loop < 100; loop++) { //taking 100 samples
      int[] input = new int[100];
      for (int i = 0; i < 100; i++) {
        input[i] = StdRandom.uniform(100);
      }
      StdArrayIO.print(input);
      System.out.println("===============");
      SelectionSort.sort2(input);
      StdArrayIO.print(input);
      for (int i = 1; i < input.length; i++) {
        Assert.assertTrue(input[i-1] <= input[i]);
      }
    }
  }

  @Test public void testMinCheck() {
    int[] input = {1, 3, 6, 12, 19, 27};
    for (int i = 1; i < input.length; i++) {
      Assert.assertTrue(input[i-1] <= input[i]);
    }
  }
}