package ds;

import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Nabeel Ali Memon
 */
public class ListTest {
  @Test public void shouldAddNewElements() {
    List<String> list = new List<>();
    list.add("a");
    list.add("b");
    list.add("c");
    Assert.assertEquals(3, list.size());
  }

  @Test public void shouldGrowDynamically() {
    Random rand = new Random();
    List<Integer> list = new List<>();
    for (int i = 0; i < 20; i++) {
      list.add(rand.nextInt());
    }
    Assert.assertEquals(20, list.size());
  }
  
  @Test public void shouldGrowDynamicallyAfterExpSize() {
    List<String> list = new List<>(2);
    list.add("a");
    list.add("b");
    list.add("c");
    Assert.assertEquals(3, list.size());
  }
  
  @Test public void shouldVerifyElementExists() {
    List<String> list = new List<>();
    list.add("a");
    list.add("b");
    list.add("c");
    Assert.assertTrue(list.contains("b"));
  }
  
  @Test(expected = ConcurrentModificationException.class) 
  public void shouldNotAllowMutationDuringIteration() {
    List<String> list = new List<>();
    list.add("a");
    list.add("b");
    Iterator<String> iter = list.iterator();
    Assert.assertTrue(iter.hasNext());
    Assert.assertEquals("a", iter.next());
    list.add("c");
    iter.next();
  }
}
