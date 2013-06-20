import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Convenience methods and utilities for frequent use 
 * while developing algorithms.
 * 
 * @author Nabeel Ali Memon
 */
public class Utils {

  /**
   * Swap left-indexed variable with right-indexed one
   * 
   * @param input array
   * @param left index of left
   * @param right index of right
   */
  static void exch(int[] input, int left, int right) {
    int temp = input[left];
    input[left] = input[right];
    input[right] = temp;
  }

  /**
   * File reader that can read files of virtually any size
   * in streams. 
   * Note: Memory references like streams are not closed 
   * until all contents of file are read.
   */
  static class FileStreamReader {
    final char[] buffer;
    final String fileName;
    final BufferedInputStream stream;
    final InputStreamReader streamReader;
    int looper = 0;

    /**
     * Constructs a file reader with the provided fileName.
     * Note: fileName is supposed to be under current
     * package (or no-package for this class).
     * 
     * @param fileName name of file (with extension) to read from
     */
    FileStreamReader(String fileName) {
      this(fileName, 1024);
    }

    /**
     * Constructs a file reader with the provided fileName
     * and buffer size to keep while reading the stream.
     * Note: fileName is supposed to be under current
     * package (or no-package for this class).
     * 
     * @param fileName name of file (with extension) to read from
     * @param bufferSize size of buffer to keep while reading
     */
    FileStreamReader(String fileName, int bufferSize) {
      this.fileName = fileName;
      buffer = new char[bufferSize];
      try {
        stream = new BufferedInputStream(Utils.class.getResource(fileName).openStream());
        streamReader = new InputStreamReader(stream);
      } catch (IOException ioe) {
        throw new RuntimeException(ioe);
      }
    }

    /**
     * Reads one chunk at a time. The chunk size is either
     * "1024" or the one provided through {@link #FileStreamReader(String, int)}.
     * To read the entire file-content in one go, the client 
     * is supposed to call this method in a loop and should
     * expect to get {@code null} when there's no more content to 
     * read from the file.
     * Note: streams or any other resources will not close until
     * the entire content of file is read.
     * 
     * @return new {@code String} of the content buffer read from the file
     */
    String readBuffer() {
      try {
        looper = streamReader.read(buffer);
        if (looper != -1) {
          final String temp = new String(buffer);
          return temp;
        } else {
          houseKeeping();
          return null;
        }
      } catch (IOException ioe) {
        houseKeeping();
        throw new RuntimeException(ioe);
      }
    }

    /**
     * Internal house keeping method that shuts
     * down memory references used during the file reading.
     */
    void houseKeeping() {
      try {
        streamReader.close();
        stream.close();
      } catch (IOException ioe) {
        throw new RuntimeException(ioe);
      }
    }
  }
}
