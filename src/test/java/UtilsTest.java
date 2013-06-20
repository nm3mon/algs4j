import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

/**
 * @author Nabeel Ali Memon
 */
public class UtilsTest {
  @Test public void shouldReadCompleteSmallFileInBuffers() {
    final Utils.FileStreamReader reader = new Utils.FileStreamReader("tinyTale.txt");
    String oldLine = "";
    String newLine = "";
    int counter = 0;
    while ((newLine = reader.readBuffer()) != null) {
      System.out.println(newLine);
      Assert.assertNotSame(oldLine, newLine);
      oldLine = newLine;
      counter += 1;
    }
    Assert.assertEquals(1, counter);
  }

  @Test public void shouldReadCompleteLargeFileInBuffers() {
    final Utils.FileStreamReader reader = new Utils.FileStreamReader("tale.txt");
    String oldLine = "";
    String newLine = "";
    int counter = 0;
    while ((newLine = reader.readBuffer()) != null) {
      System.out.println(newLine);
      Assert.assertNotSame(oldLine, newLine);
      oldLine = newLine;
      counter += 1;
    }
    Assert.assertEquals(710, counter);
  }

  @Test @Ignore //very slow because of huge file size 
  public void shouldReadCompleteMonsterFileInBuffers() {
    final Utils.FileStreamReader reader = new Utils.FileStreamReader("leipzig1M.txt");
    String oldLine = "";
    String newLine = "";
    int counter = 0;
    while ((newLine = reader.readBuffer()) != null) {
      System.out.println(newLine);
      Assert.assertNotSame(oldLine, newLine);
      oldLine = newLine;
      counter += 1;
    }
    Assert.assertEquals(100000, counter);
  }

  @Test public void shouldLoadFileInStreamAdhoc() throws IOException {
    final BufferedInputStream stream = new BufferedInputStream(
        this.getClass().getResource("leipzig1M.txt").openStream()
    );
    try (InputStreamReader reader = new InputStreamReader(stream);
         StringWriter writer = new StringWriter()) {
      char[] buffer = new char[1024];
      int n;
      while ((n = reader.read(buffer)) != -1) {
        writer.write(buffer, 0, n);
        System.out.println(writer.getBuffer().toString());
      }
    }
  }
}
