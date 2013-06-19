/**
 * @author Nabeel Ali Memon
 */
public class Utils {
  static void exch(int[] input, int left, int right) {
    int temp = input[left];
    input[left] = input[right];
    input[right] = temp;
  }
}
