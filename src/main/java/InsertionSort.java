/**
 * @author Nabeel Ali Memon
 */
public class InsertionSort {
  static void sort(int[] input) {
    for (int i = 1; i < input.length; i++) {
      for (int j = i; j > 0 && input[j] < input[j-1]; j--) {
        Utils.exch(input, j, j-1);
      }
    }
  }
}