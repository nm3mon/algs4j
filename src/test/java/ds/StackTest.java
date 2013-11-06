package ds;

import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Nabeel Ali Memon
 */
public class StackTest {
  @Test public void shouldPush() {
    Stack<Integer> s = new Stack<>();
    s.push(7);
    s.push(3);
    s.push(5);
    s.push(1);
    s.push(11);
    Assert.assertEquals(5, s.size());
  }
  
  @Test public void shouldPop() {
    Stack<Integer> s = new Stack<>();
    s.push(7);
    s.push(3);
    s.push(5);
    s.push(1);
    s.push(11);
    Assert.assertEquals(11, s.pop().intValue());
    Assert.assertEquals(1, s.pop().intValue());
    Assert.assertEquals(5, s.pop().intValue());
  }

  @Test public void shouldGrowDynamically() {
    Random rand = new Random();
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < 20; i++) {
      s.push(rand.nextInt());
    }
    Assert.assertEquals(20, s.size());
    s.push(12);
    s.push(13);
    Assert.assertEquals(22, s.size());
  }

  @Test public void shouldGrowDynamicallyAfterExpSize() {
    Stack<Integer> s = new Stack<>(3);
    s.push(7);
    s.push(3);
    s.push(5);
    s.push(1);
    s.push(11);
    Assert.assertEquals(5, s.size());
  }
  
  @Test public void shouldIterateInLIFOOrder() {
    Stack<Integer> s = new Stack<>(3);
    s.push(7);
    s.push(3);
    s.push(5);
    s.push(1);
    s.push(11);
    Iterator<Integer> iter = s.iterator();
    Assert.assertEquals(11, iter.next().intValue());
    Assert.assertEquals(1, iter.next().intValue());
    Assert.assertEquals(5, iter.next().intValue());
    Assert.assertEquals(3, iter.next().intValue());
    Assert.assertEquals(7, iter.next().intValue());
  }
  
  @Test(expected = ConcurrentModificationException.class)
  public void shouldNotAllowMutationDuringIteration() {
    Stack<Integer> s = new Stack<>(3);
    s.push(7);
    s.push(3);
    s.push(11);
    Iterator<Integer> iter = s.iterator();
    Assert.assertTrue(iter.hasNext());
    Assert.assertEquals(11, iter.next().intValue());
    s.push(31);
    iter.next();
  }
}
