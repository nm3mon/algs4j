package ds;

import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Nabeel Ali Memon
 */
public class QueueTest {
  @Test public void shouldEnqueue() {
    Queue<Integer> q = new Queue<>();
    q.enqueue(2);
    q.enqueue(5);
    q.enqueue(1);
    Assert.assertEquals(3, q.size());
  }
  
  @Test public void shouldDequeue() {
    Queue<Integer> q = new Queue<>();
    q.enqueue(2);
    q.enqueue(5);
    q.enqueue(1);
    Assert.assertEquals(2, q.dequeue().intValue());
    Assert.assertEquals(5, q.dequeue().intValue());
    Assert.assertEquals(1, q.dequeue().intValue());
  }
  
  @Test public void shouldGrowDynamicallyAfterExpSize() {
    Queue<Integer> q = new Queue<>(2);
    q.enqueue(2);
    q.enqueue(5);
    q.enqueue(1);
    Assert.assertEquals(3, q.size());
    
    q.dequeue();
    q.enqueue(5);
    q.enqueue(1);
    q.enqueue(7);
    Assert.assertEquals(5, q.size());
  }
  
  @Test public void shouldGrowDynamically() {
    Random rand = new Random();
    Queue<Integer> q = new Queue<>();
    for (int i = 0; i < 20; i++) {
      q.enqueue(rand.nextInt());
    }
    Assert.assertEquals(20, q.size());
    q.enqueue(31);
    q.enqueue(33);
    Assert.assertEquals(22, q.size());

    for (int i = 0; i < 10; i++) {
      q.dequeue();
    }
    Assert.assertEquals(12, q.size());

    for (int i = 0; i < 30; i++) {
      q.enqueue(rand.nextInt());
    }
    Assert.assertEquals(42, q.size());
  }
  
  @Test public void shouldIterateInFIFOOrder() {
    Queue<Integer> q = new Queue<>(3);
    q.enqueue(2);
    q.enqueue(5);
    q.enqueue(1);
    q.enqueue(31);
    q.enqueue(55);
    Iterator<Integer> iter = q.iterator();
    Assert.assertTrue(iter.hasNext());
    Assert.assertEquals(2, iter.next().intValue());
    Assert.assertTrue(iter.hasNext());
    Assert.assertEquals(5, iter.next().intValue());
    Assert.assertTrue(iter.hasNext());
    Assert.assertEquals(1, iter.next().intValue());
    Assert.assertTrue(iter.hasNext());
    Assert.assertEquals(31, iter.next().intValue());
    Assert.assertTrue(iter.hasNext());
    Assert.assertEquals(55, iter.next().intValue());
    Assert.assertFalse(iter.hasNext());
  }
  
  @Test(expected = ConcurrentModificationException.class) 
  public void shouldNotAllowMutationDuringIteration() {
    Queue<Integer> q = new Queue<>();
    q.enqueue(2);
    q.enqueue(5);
    q.enqueue(1);
    Iterator<Integer> iter = q.iterator();
    Assert.assertTrue(iter.hasNext());
    Assert.assertEquals(2, iter.next().intValue());
    q.enqueue(7);
    iter.next();
  }
}
