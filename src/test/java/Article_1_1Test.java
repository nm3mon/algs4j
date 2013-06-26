import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author Nabeel Ali Memon
 */
public class Article_1_1Test {
  public static class ResizingArrayStackTest {
    @Test public void shouldPushAndPopElement() {
      Article_1_1.Stack<String> dynamicStack = new Article_1_1.ResizingArrayStack<>(2);
      Assert.assertEquals(0, dynamicStack.size());
      dynamicStack.push("Nabeel");
      Assert.assertEquals(1, dynamicStack.size());
      dynamicStack.push("Memon");
      Assert.assertEquals(2, dynamicStack.size());
      Assert.assertEquals("Memon", dynamicStack.pop());
      Assert.assertEquals(1, dynamicStack.size());
      Assert.assertEquals("Nabeel", dynamicStack.pop());
      Assert.assertEquals(0, dynamicStack.size());
    }

    @Test public void shouldIterateOverStack() {
      Article_1_1.Stack<String> dynamicStack = new Article_1_1.ResizingArrayStack<>(5);
      dynamicStack.push("Engineer");
      dynamicStack.push("Software");
      dynamicStack.push("Memon");
      dynamicStack.push("Ali");
      dynamicStack.push("Nabeel");
      Iterator<String> stackIterator = dynamicStack.iterator();
      Assert.assertTrue(stackIterator.hasNext());
      Assert.assertEquals("Nabeel", stackIterator.next());
      Assert.assertTrue(stackIterator.hasNext());
      Assert.assertEquals("Ali", stackIterator.next());
      Assert.assertTrue(stackIterator.hasNext());
      Assert.assertEquals("Memon", stackIterator.next());
      Assert.assertTrue(stackIterator.hasNext());
      Assert.assertEquals("Software", stackIterator.next());
      Assert.assertTrue(stackIterator.hasNext());
      Assert.assertEquals("Engineer", stackIterator.next());
      Assert.assertFalse(stackIterator.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shouldThrowCMEIfModifiedDuringIteration() {
      Article_1_1.Stack<String> dynamicStack = new Article_1_1.ResizingArrayStack<>(5);
      dynamicStack.push("Engineer");
      dynamicStack.push("Software");
      Iterator<String> stackIterator = dynamicStack.iterator();
      Assert.assertTrue(stackIterator.hasNext());
      Assert.assertEquals("Software", stackIterator.next());
      dynamicStack.push("Nabeel");
      Assert.assertTrue(stackIterator.hasNext());
      stackIterator.next();
    }
  }
}
