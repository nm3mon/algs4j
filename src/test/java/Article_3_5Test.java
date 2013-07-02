import org.junit.*;

/**
 * @author Nabeel Ali Memon
 */
public class Article_3_5Test {
  @Test public void shouldBeAbleToPutEntries() {
    Article_3_5.SeparateChainingHashST<String, String> map =
        new Article_3_5.SeparateChainingHashST<>();
    map.put("firstName", "Nabeel");
    map.put("secondName", "Nabeel");
    Assert.assertEquals(2, map.size());
  }

  @Test public void shouldBeAbleToGetEntries() {
    Article_3_5.SeparateChainingHashST<String, String> map =
        new Article_3_5.SeparateChainingHashST<>();
    map.put("firstName", "Nabeel");
    map.put("secondName", "Nabeel");
    Assert.assertEquals("Nabeel", map.get("firstName"));
    Assert.assertNull(map.get("thirdName"));
  }

  @Test public void keyDistributionCheck() {
    Utils.FileStreamReader fileReader = new Utils.FileStreamReader("tale.txt");
    String buffer;
    Article_3_5.SeparateChainingHashST<String, Integer> map =
        new Article_3_5.SeparateChainingHashST<>();
    while ((buffer = fileReader.readBuffer()) != null) {
      String[] words = buffer.split(" ");
      for (String word : words) {
        map.put(word, word.length());
      }
    }
    System.out.println(map.size());
  }
}