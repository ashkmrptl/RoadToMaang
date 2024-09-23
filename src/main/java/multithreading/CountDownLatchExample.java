package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Use-case:
 * Consider the case of a birthday party.
 * We need to wait for all the guests to arrive before revealing the surprise to our friend.
 * Hence, we start a latch with no of guests, and as soon as a guest arrives, we count down the latch counter.
 * Once the latch reaches to zero, the waiting threads start processing.
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int noOfGuests = 10;
        final CountDownLatch arrivalLatch = new CountDownLatch(noOfGuests);

        for (int i = 1; i <= noOfGuests; i++) {
            final Thread guestThread = new Thread(new Guest("Guest" + i, i * 1000L, arrivalLatch));
            guestThread.start();
        }

        System.out.println("Waiting for all the guests to arrive");
        try {
            arrivalLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All guests arrived, revealing the surprise now");


        final List<Runnable> runnables = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(runnables.size());

        final List<Future> futures = new ArrayList<>();
        for (final Runnable r: runnables) {
            futures.add(es.submit(r));
        }

        for (Future f: futures) {
            f.get();
        }

        es.shutdown();
    }

    private static class Guest implements Runnable {
        final String name;
        final long waitingTime;
        final CountDownLatch arrivalLatch;

        public Guest(final String name, final long waitingTime, final CountDownLatch arrivalLatch) {
            this.name = name;
            this.waitingTime = waitingTime;
            this.arrivalLatch = arrivalLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(waitingTime);
                System.out.println(name + " has arrived");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            arrivalLatch.countDown();
        }
    }
}
