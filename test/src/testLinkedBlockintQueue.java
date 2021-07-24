import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class testLinkedBlockintQueue {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> strs = new LinkedBlockingQueue<>(2);
        // strs.offer("!");
        // strs.offer("2");
        // strs.offer("3");
        // strs.offer("4");
        strs.add("!");
        strs.add("2");
        strs.add("3");
        strs.add("4");
    }

    SynchronousQueue<String> strings = new SynchronousQueue<>();

    @Test
    public void testSynchronousQueue() throws InterruptedException {
        // boolean offer = strings.offer("1");
        // boolean offer1 = strings.offer("2");
        // boolean offer2 = strings.offer("3");

        strings.put("1");
        strings.put("2");
        strings.put("3");
    }

    @Test
    public void testSynchronousQueue1() throws InterruptedException {
        // boolean offer = strings.offer("1");
        // boolean offer1 = strings.offer("2");
        // boolean offer2 = strings.offer("3");

        String take = strings.take();
        String take1 = strings.take();
        String take2 = strings.take();

    }
}
