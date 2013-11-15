package monad;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Nabeel Ali Memon
 */
public class CFuture {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Double answer = CompletableFuture
        .supplyAsync(() -> "42")
        .thenApplyAsync(Integer::parseInt)
        .thenApplyAsync(r -> r * r * Math.PI)
//        .thenAcceptAsync(() -> Thread.sleep(3000))
        .getNow(3.14);
    System.out.println(answer);
  }
}
