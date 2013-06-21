import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Nabeel Ali Memon
 */
public class Article_3_1Test {
  public static class SequentialSearchSTTest {
    @Test public void shouldBeAbleToPutNewEntries() {
      Article_3_1.ST<String, String> sequence = new Article_3_1.SequentialSearch<>();
      Assert.assertEquals(0, sequence.size());
      sequence.put("firstName", "Nabeel");
      Assert.assertEquals(1, sequence.size());
      sequence.put("middleName", "Ali");
      Assert.assertEquals(2, sequence.size());
      sequence.put("lastName", "Memon");
      Assert.assertEquals(3, sequence.size());
    }
    
    @Test public void shouldBeAbleToSearchAddedEntries() {
      Article_3_1.ST<String, String> sequence = new Article_3_1.SequentialSearch<>();
      Assert.assertNull(sequence.get("firstName"));
      sequence.put("firstName", "Nabeel");
      Assert.assertNotNull(sequence.get("firstName"));
      Assert.assertEquals("Nabeel", sequence.get("firstName"));
    }

    @Test public void shouldBeAbleToUpdateEntries() {
      Article_3_1.ST<String, String> sequence = new Article_3_1.SequentialSearch<>();
      sequence.put("firstName", "Nabeel");
      Assert.assertEquals("Nabeel", sequence.get("firstName"));
      sequence.put("firstName", "Ummamah");
      Assert.assertEquals("Ummamah", sequence.get("firstName"));
    }
    
    @Test public void shouldBeAbleToRemoveFirstEntry() {
      Article_3_1.ST<String, String> sequence = new Article_3_1.SequentialSearch<>();
      sequence.put("firstName", "Nabeel");
      Assert.assertEquals(1, sequence.size());
      sequence.delete("firstName");
      Assert.assertNull(sequence.get("firstName"));
      Assert.assertEquals(0, sequence.size());
    }

    @Test public void shouldBeAbleToRemoveNonFirstEntry() {
      Article_3_1.ST<String, String> sequence = new Article_3_1.SequentialSearch<>();
      sequence.put("firstName", "Nabeel");
      sequence.put("middleName", "Ali");
      Assert.assertEquals(2, sequence.size());
      sequence.delete("middleName");
      Assert.assertNull(sequence.get("middleName"));
      Assert.assertEquals(1, sequence.size());
      sequence.delete("firstName");
      Assert.assertEquals(0, sequence.size());
    }
    
    @Test public void loadModestData() {
      Article_3_1.ST<String, Integer> sequence = new Article_3_1.SequentialSearch<>();
      Utils.FileStreamReader fileReader = new Utils.FileStreamReader("leipzig1M.txt");
      String buffer;
      Utils.Stopwatch timer = new Utils.Stopwatch();
      while ((buffer = fileReader.readBuffer()) != null) {
        String[] words = buffer.split(" ");
        for (String word : words) {
          if (word.length() >= 4) {
            sequence.put(word, word.length());
          }
        }
      }
      System.out.println("total put operations took: "+timer.elapsed(TimeUnit.SECONDS)+ " sec");
      System.out.println("size of sequence: "+sequence.size());
      timer.reset();
      Integer childWordLength = sequence.get("child");
      Assert.assertNotNull(childWordLength);
      Assert.assertTrue(childWordLength > 0);
      System.out.println("word child's frequency is : " + childWordLength);
      System.out.println("get(child) took: " + timer.elapsed() + " ms");
    }
  }

  public static class BinarySearchSTTest {
    @Test public void shouldBeAbleToPutANewEntry() {
      Article_3_1.BinarySearchST<String, String> orderedSequence = new Article_3_1.BinarySearchST<>(31);
      orderedSequence.put("firstName", "Nabeel");
      Assert.assertEquals(1, orderedSequence.size());
      orderedSequence.put("secondName", "Ali");
      Assert.assertEquals(2, orderedSequence.size());
      orderedSequence.put("thirdName", "Memon");
      Assert.assertEquals(3, orderedSequence.size());
    }

    @Test public void shouldBeAbleToGetAnExistingEntry() {
      Article_3_1.BinarySearchST<String, String> orderedSequence = new Article_3_1.BinarySearchST<>(31);
      orderedSequence.put("firstName", "Nabeel");
      orderedSequence.put("secondName", "Ali");
      orderedSequence.put("thirdName", "Memon");
      Assert.assertEquals("Nabeel", orderedSequence.get("firstName"));
      Assert.assertEquals("Ali", orderedSequence.get("secondName"));
      Assert.assertEquals("Memon", orderedSequence.get("thirdName"));
    }

    @Test public void shouldBeAbleToUpdateAnExistingEntry() {
      Article_3_1.BinarySearchST<String, String> orderedSequence = new Article_3_1.BinarySearchST<>(31);
      orderedSequence.put("firstName", "Nabeel");
      orderedSequence.put("firstName", "Ummamah");
      Assert.assertEquals(1, orderedSequence.size());
      Assert.assertEquals("Ummamah", orderedSequence.get("firstName"));
    }
  }
}
