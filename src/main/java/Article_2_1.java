/**
 * @author Nabeel Ali Memon
 */
public class Article_2_1 {
  public static class InsertionSort {
    static void sort(int[] input) {
      for (int i = 1; i < input.length; i++) {
        for (int j = i; j > 0 && input[j] < input[j-1]; j--) {
          Utils.exch(input, j, j-1);
        }
      }
    }
  }

  public static class SelectionSort {
    static void sort2(int[] input) {
      int min;
      for (int i = 0; i < input.length; i++) {
        min = i;
        for (int j = i; j < input.length; j++) {
          if (input[j] < input[min]) {
            min = j;
          }
        }
        Utils.exch(input, i, min);
      }
    }
  }
}
