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
  
  public static class LinkedStackTest {
    @Test public void shouldPushAndPopElement() {
      Article_1_1.Stack<String> linkedStack = new Article_1_1.LinkedStack<>();
      Assert.assertEquals(0, linkedStack.size());
      linkedStack.push("Nabeel");
      Assert.assertEquals(1, linkedStack.size());
      linkedStack.push("Memon");
      Assert.assertEquals(2, linkedStack.size());
      Assert.assertEquals("Memon", linkedStack.pop());
      Assert.assertEquals(1, linkedStack.size());
      Assert.assertEquals("Nabeel", linkedStack.pop());
      Assert.assertEquals(0, linkedStack.size());
    }

    @Test public void shouldIterateOverStack() {
      Article_1_1.Stack<String> linkedStack = new Article_1_1.LinkedStack<>();
      linkedStack.push("Engineer");
      linkedStack.push("Software");
      linkedStack.push("Memon");
      linkedStack.push("Ali");
      linkedStack.push("Nabeel");
      Iterator<String> stackIterator = linkedStack.iterator();
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
      Article_1_1.Stack<String> linkedStack = new Article_1_1.LinkedStack<>();
      linkedStack.push("Engineer");
      linkedStack.push("Software");
      Iterator<String> stackIterator = linkedStack.iterator();
      Assert.assertTrue(stackIterator.hasNext());
      Assert.assertEquals("Software", stackIterator.next());
      linkedStack.push("Nabeel");
      Assert.assertTrue(stackIterator.hasNext());
      stackIterator.next();
    }
  }
}
