import java.util.concurrent.*;
import java.util.Random;

public class RandomSquareCube {
    public static void main(String[] args) {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(10);
        Thread generator = new Thread(new Generator(q), "Generator");
        Thread squareWorker = new Thread(new SquareWorker(q), "SquareThread");
        Thread cubeWorker = new Thread(new CubeWorker(q), "CubeThread");

        generator.start();
        squareWorker.start();
        cubeWorker.start();
    }

    static class Generator implements Runnable {
        private final BlockingQueue<Integer> q;
        private final Random r = new Random();
        public Generator(BlockingQueue<Integer> q) { this.q = q; }
        public void run() {
            try {
                while (true) {
                    int num = r.nextInt(100); // 0..99
                    q.put(num);
                    System.out.println("Generated: " + num);
                    Thread.sleep(1000); // 1 second
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }

    static class SquareWorker implements Runnable {
        private final BlockingQueue<Integer> q;
        public SquareWorker(BlockingQueue<Integer> q) { this.q = q; }
        public void run() {
            try {
                while (true) {
                    Integer n = q.take();
                    if (n % 2 == 0) {
                        System.out.println("SquareThread: " + n + " -> " + (n * n));
                    } else {
                        // if odd, put back so cube thread can process (simple cooperative approach)
                        q.put(n);
                        Thread.sleep(10); // small pause to avoid busy loop
                    }
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }

    static class CubeWorker implements Runnable {
        private final BlockingQueue<Integer> q;
        public CubeWorker(BlockingQueue<Integer> q) { this.q = q; }
        public void run() {
            try {
                while (true) {
                    Integer n = q.take();
                    if (n % 2 != 0) {
                        System.out.println("CubeThread: " + n + " -> " + (n * n * n));
                    } else {
                        // if even, put back so square thread can process
                        q.put(n);
                        Thread.sleep(10);
                    }
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }
}
