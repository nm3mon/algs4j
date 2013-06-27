import org.junit.Assert;
import org.junit.Before;
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
                     Article_1_1Test.LinkedListTest.class,
                     Article_1_1Test.E_1_3_1Test.class,
                     Article_1_1Test.E_1_3_27Test.class,
                     Article_1_1Test.E_1_3_30Test.class})
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

  public static class LinkedListTest {
    @Test public void shouldAddUpNodes() {
      Article_1_1.List<String> linkedList = new Article_1_1.LinkedList<>();
      Assert.assertEquals(0, linkedList.size());
      linkedList.add("Nabeel");
      Assert.assertEquals(1, linkedList.size());
      linkedList.add("Memon");
      Assert.assertEquals(2, linkedList.size());
    }

    @Test public void shouldReturnItemAtGivenIndex() {
      Article_1_1.List<String> linkedList = new Article_1_1.LinkedList<>();
      linkedList.add("Nabeel");
      linkedList.add("Memon");
      Assert.assertEquals("Nabeel", linkedList.get(0));
      Assert.assertEquals("Memon", linkedList.get(1));
    }

    @Test public void shouldRemoveItemAtGivenIndex() {
      Article_1_1.List<String> linkedList = new Article_1_1.LinkedList<>();
      linkedList.add("Nabeel");
      linkedList.add("Ali");
      linkedList.add("Memon");
      Assert.assertEquals(3, linkedList.size());
      Assert.assertEquals("Ali", linkedList.remove(1));
      Assert.assertEquals(2, linkedList.size());
      Assert.assertEquals("Memon", linkedList.remove(1));
      Assert.assertEquals(1, linkedList.size());
      Assert.assertEquals("Nabeel", linkedList.remove(0));
      Assert.assertEquals(0, linkedList.size());
    }

    @Test public void shouldRemoveAllEqualItems() {
      Article_1_1.List<String> linkedList = new Article_1_1.LinkedList<>();
      linkedList.add("Software");
      linkedList.add("Java");
      linkedList.add("Software");
      Assert.assertEquals(3, linkedList.size());
      linkedList.remove("Software");
      Assert.assertEquals(1, linkedList.size());
      linkedList.remove("Java");
      Assert.assertEquals(0, linkedList.size());
    }

    @Test public void shouldIteratorInInsertionOrder() {
      Article_1_1.List<String> linkedList = new Article_1_1.LinkedList<>();
      linkedList.add("Nabeel");
      linkedList.add("Ali");
      linkedList.add("Memon");
      linkedList.add("Software");
      linkedList.add("Engineer");
      Iterator<String> listIterator = linkedList.iterator();
      Assert.assertTrue(listIterator.hasNext());
      Assert.assertEquals("Nabeel", listIterator.next());
      Assert.assertTrue(listIterator.hasNext());
      Assert.assertEquals("Ali", listIterator.next());
      Assert.assertTrue(listIterator.hasNext());
      Assert.assertEquals("Memon", listIterator.next());
      Assert.assertTrue(listIterator.hasNext());
      Assert.assertEquals("Software", listIterator.next());
      Assert.assertTrue(listIterator.hasNext());
      Assert.assertEquals("Engineer", listIterator.next());
      Assert.assertFalse(listIterator.hasNext());
    }

    @Test public void shouldEncounterHeadNextToTail() {
      Article_1_1.List<String> linkedList = new Article_1_1.LinkedList<>(true);
      linkedList.add("Nabeel");
      linkedList.add("Ali");
      linkedList.add("Memon");
      Iterator<String> listIterator = linkedList.iterator();
      listIterator.next();
      listIterator.next();
      listIterator.next();
      Assert.assertTrue(listIterator.hasNext());
      Assert.assertEquals("Nabeel", listIterator.next());
    }

    @Test public void shouldEncounterTailPreviousToHead() {
      Article_1_1.LinkedList<String> linkedList = new Article_1_1.LinkedList<>(true);
      linkedList.add("Nabeel");
      linkedList.add("Ali");
      linkedList.add("Memon");
      Assert.assertEquals("Memon", linkedList.head.prev.data);
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

  public static class E_1_3_27Test {
    @Test public void findMax() {
      Article_1_1.LinkedList<Integer> linkedList = new Article_1_1.LinkedList<>();
      linkedList.add(13);
      linkedList.add(1);
      linkedList.add(131);
      linkedList.add(3);
      linkedList.add(45);
      linkedList.add(6);
      linkedList.add(9);
      linkedList.add(113);
      linkedList.add(167);
      linkedList.add(257);
      int number = Integer.MIN_VALUE;
      //iterative version
      for (Integer item : linkedList) {
        if (item > number) {
          number = item;
        }
      }
      System.out.println("Iterative 1: Max number in this list was "+ number);

      Article_1_1.LinkedNode<Integer> current = linkedList.head;
      number = Integer.MIN_VALUE; //reset
      while (current != null) {
        if (number < current.data ) {
          number = current.data;
        }
        current = current.next;
      }
      System.out.println("Iterative 2: Max number in this list was "+ number);

      number = Integer.MIN_VALUE; //reset
      number = getBiggestNumber(number, linkedList.head);
      System.out.println("Recursive: Max number in this list was "+ number);
    }

    int getBiggestNumber(int previousNumber, Article_1_1.LinkedNode<Integer> node) {
      if (node == null) {
        return previousNumber;
      }
      if (previousNumber < node.data) {
        previousNumber = node.data;
      }
      return getBiggestNumber(previousNumber, node.next);
    }
  }

  public static class E_1_3_30Test {
    Article_1_1.LinkedList<String> linkedList;

    @Before public void setUp() {
      linkedList = new Article_1_1.LinkedList<>();
      linkedList.add("Nabeel");
      linkedList.add("Ali");
      linkedList.add("Memon");
      linkedList.add("Software");
      linkedList.add("Engineer");
      linkedList.add("On");
      linkedList.add("JVM");
    }

    @Test public void iterativeListReversal() {
      Article_1_1.LinkedNode<String> head = linkedList.head;
      Article_1_1.LinkedNode<String> current = head;
      while (head.next != null) {
        current.prev = head.next;
        head.next = head.next.next;
        current.prev.next = current;
        current = current.prev;
      }
      Assert.assertEquals("JVM", current.data); //first node in the result
      linkedList.head = current;
      linkedList.tail = head;
      Iterator<String> listIterator = linkedList.iterator();
      Assert.assertEquals(7, linkedList.size());
      Assert.assertEquals("JVM", listIterator.next());
      Assert.assertEquals("On", listIterator.next());
      Assert.assertEquals("Engineer", listIterator.next());
      Assert.assertEquals("Software", listIterator.next());
      Assert.assertEquals("Memon", listIterator.next());
      Assert.assertEquals("Ali", listIterator.next());
      Assert.assertEquals("Nabeel", listIterator.next());
      Assert.assertFalse(listIterator.hasNext());
    }

    @Test public void RecursiveListReversal() {
      Article_1_1.LinkedNode<String> head = linkedList.head;
      Article_1_1.LinkedNode<String> current = head;
      Article_1_1.LinkedNode<String> firstVariable = reverse(head, current);
      Assert.assertEquals("JVM", firstVariable.data); //first node in the result
      linkedList.head = firstVariable;
      linkedList.tail = head;
      Iterator<String> listIterator = linkedList.iterator();
      Assert.assertEquals(7, linkedList.size());
      Assert.assertEquals("JVM", listIterator.next());
      Assert.assertEquals("On", listIterator.next());
      Assert.assertEquals("Engineer", listIterator.next());
      Assert.assertEquals("Software", listIterator.next());
      Assert.assertEquals("Memon", listIterator.next());
      Assert.assertEquals("Ali", listIterator.next());
      Assert.assertEquals("Nabeel", listIterator.next());
      Assert.assertFalse(listIterator.hasNext());
    }

    <Item> Article_1_1.LinkedNode<Item> reverse(Article_1_1.LinkedNode<Item> head,
                                                Article_1_1.LinkedNode<Item> current) {
      if (head.next == null) {
        return current;
      }
      current.prev = head.next;
      head.next = head.next.next;
      current.prev.next = current;
      current = current.prev;
      return reverse(head, current);
    }
  }
}
