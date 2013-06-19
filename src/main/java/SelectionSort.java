/**
 * @author Nabeel Ali Memon
 */
public class SelectionSort {
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
