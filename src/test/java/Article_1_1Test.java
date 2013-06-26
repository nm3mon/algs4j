import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.Suite;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author Nabeel Ali Memon
 */

@Suite.SuiteClasses({Article_1_1Test.ResizingArrayStackTest.class, 
                     Article_1_1Test.LinkedStackTest.class,
                     Article_1_1Test.LinkedQueueTest.class,
                     Article_1_1Test.LinkedBagTest.class,
                     Article_1_1Test.E_1_3_1Test.class})
@RunWith(Suite.class)
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
  
  public static class LinkedQueueTest {
    @Test public void shouldPushAndPopElement() {
      Article_1_1.Queue<String> linkedQueue = new Article_1_1.LinkedQueue<>();
      Assert.assertEquals(0, linkedQueue.size());
      linkedQueue.enqueue("Nabeel");
      Assert.assertEquals(1, linkedQueue.size());
      linkedQueue.enqueue("Memon");
      Assert.assertEquals(2, linkedQueue.size());
      Assert.assertEquals("Nabeel", linkedQueue.dequeue());
      Assert.assertEquals(1, linkedQueue.size());
      Assert.assertEquals("Memon", linkedQueue.dequeue());
      Assert.assertEquals(0, linkedQueue.size());
    }

    @Test public void shouldIterateOverStack() {
      Article_1_1.Queue<String> linkedQueue = new Article_1_1.LinkedQueue<>();
      linkedQueue.enqueue("Nabeel");
      linkedQueue.enqueue("Ali");
      linkedQueue.enqueue("Memon");
      linkedQueue.enqueue("Software");
      linkedQueue.enqueue("Engineer");
      Iterator<String> queueIterator = linkedQueue.iterator();
      Assert.assertTrue(queueIterator.hasNext());
      Assert.assertEquals("Nabeel", queueIterator.next());
      Assert.assertTrue(queueIterator.hasNext());
      Assert.assertEquals("Ali", queueIterator.next());
      Assert.assertTrue(queueIterator.hasNext());
      Assert.assertEquals("Memon", queueIterator.next());
      Assert.assertTrue(queueIterator.hasNext());
      Assert.assertEquals("Software", queueIterator.next());
      Assert.assertTrue(queueIterator.hasNext());
      Assert.assertEquals("Engineer", queueIterator.next());
      Assert.assertFalse(queueIterator.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shouldThrowCMEIfModifiedDuringIteration() {
      Article_1_1.Queue<String> linkedQueue = new Article_1_1.LinkedQueue<>();
      linkedQueue.enqueue("Software");
      linkedQueue.enqueue("Engineer");
      Iterator<String> queueIterator = linkedQueue.iterator();
      Assert.assertTrue(queueIterator.hasNext());
      Assert.assertEquals("Software", queueIterator.next());
      linkedQueue.enqueue("Nabeel");
      Assert.assertTrue(queueIterator.hasNext());
      queueIterator.next();
    }
  }
  
  public static class LinkedBagTest {
    @Test public void shouldPushAndPopElement() {
      Article_1_1.Bag<String> linkedBag = new Article_1_1.LinkedBag<>();
      Assert.assertEquals(0, linkedBag.size());
      linkedBag.add("Nabeel");
      Assert.assertEquals(1, linkedBag.size());
      linkedBag.add("Memon");
      Assert.assertEquals(2, linkedBag.size());
    }

    @Test public void shouldIterateOverStack() {
      Article_1_1.Bag<String> linkedBag = new Article_1_1.LinkedBag<>();
      linkedBag.add("Engineer");
      linkedBag.add("Software");
      linkedBag.add("Memon");
      linkedBag.add("Ali");
      linkedBag.add("Nabeel");
      Iterator<String> bagIterator = linkedBag.iterator();
      Assert.assertTrue(bagIterator.hasNext());
      Assert.assertEquals("Nabeel", bagIterator.next());
      Assert.assertTrue(bagIterator.hasNext());
      Assert.assertEquals("Ali", bagIterator.next());
      Assert.assertTrue(bagIterator.hasNext());
      Assert.assertEquals("Memon", bagIterator.next());
      Assert.assertTrue(bagIterator.hasNext());
      Assert.assertEquals("Software", bagIterator.next());
      Assert.assertTrue(bagIterator.hasNext());
      Assert.assertEquals("Engineer", bagIterator.next());
      Assert.assertFalse(bagIterator.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shouldThrowCMEIfModifiedDuringIteration() {
      Article_1_1.Bag<String> linkedBag = new Article_1_1.LinkedBag<>();
      linkedBag.add("Engineer");
      linkedBag.add("Software");
      Iterator<String> bagIterator = linkedBag.iterator();
      Assert.assertTrue(bagIterator.hasNext());
      Assert.assertEquals("Software", bagIterator.next());
      linkedBag.add("Nabeel");
      Assert.assertTrue(bagIterator.hasNext());
      bagIterator.next();
    }
  }
  
  public static class E_1_3_1Test {
    @Test public void shouldPushAndPopElement() {
      Article_1_1.Exercise.E_1_3_1<String> fixedStack = new Article_1_1.Exercise.E_1_3_1<>(2);
      Assert.assertEquals(0, fixedStack.size());
      fixedStack.push("Nabeel");
      Assert.assertEquals(1, fixedStack.size());
      fixedStack.push("Memon");
      Assert.assertEquals(2, fixedStack.size());
      Assert.assertTrue(fixedStack.isFull());
      Assert.assertEquals("Memon", fixedStack.pop());
      Assert.assertEquals(1, fixedStack.size());
      Assert.assertEquals("Nabeel", fixedStack.pop());
      Assert.assertEquals(0, fixedStack.size());
    }

    @Test public void shouldIterateOverStack() {
      Article_1_1.Exercise.E_1_3_1<String> fixedStack = new Article_1_1.Exercise.E_1_3_1<>(5);
      fixedStack.push("Engineer");
      fixedStack.push("Software");
      fixedStack.push("Memon");
      fixedStack.push("Ali");
      fixedStack.push("Nabeel");
      Iterator<String> stackIterator = fixedStack.iterator();
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
      Article_1_1.Stack<String> fixedStack = new Article_1_1.ResizingArrayStack<>(5);
      fixedStack.push("Engineer");
      fixedStack.push("Software");
      Iterator<String> stackIterator = fixedStack.iterator();
      Assert.assertTrue(stackIterator.hasNext());
      Assert.assertEquals("Software", stackIterator.next());
      fixedStack.push("Nabeel");
      Assert.assertTrue(stackIterator.hasNext());
      stackIterator.next();
    }
  }
  
  public static class E_1_3_4Test {
    @Test public void checkParentheses() {
      
    }
  }
}
