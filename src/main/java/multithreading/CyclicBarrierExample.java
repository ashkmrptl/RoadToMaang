package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Let's consider a case where a group of friend are planning a road trip. At every meet up points every one waits for all
 * of them to reach and resume the trip again from there till all reach the end point.
 * In such scenario we need a CyclicBarrier(because the friends need to wait at every meet up points, unlike CountDownLatch
 * which waits only once)
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        final int noOfFriends = 5;
        final CyclicBarrier meetupBarrier = new CyclicBarrier(noOfFriends);

        final int meetUpPoints = 3;
        for (int j = 0; j < meetUpPoints; j++) {
            for (int i = 1; i <= noOfFriends; i++) {
                final Thread thread = new Thread(new Friend("Name" + i, i * 1000L, meetupBarrier));
                thread.start();
            }

            System.out.println("Waiting for friends to reach the meet up point: " + j);
            try {
                //meetupBarrier.await();//Simulating waiting at the meetup point
                Thread.sleep(5000L);
                System.out.println("Trip started");
            } catch (InterruptedException e) {//| BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private static class Friend implements Runnable {
        final String name;
        final long waitingTime;
        final CyclicBarrier meetupBarrier;

        public Friend(final String name, final long waitingTime, final CyclicBarrier meetupBarrier) {
            this.name = name;
            this.waitingTime = waitingTime;
            this.meetupBarrier = meetupBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(waitingTime);
                System.out.println(name + " has reached the meetup point");
                meetupBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
