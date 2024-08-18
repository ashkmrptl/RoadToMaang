package companies.paloaltonetworks.statics;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class StatisticImplAtomic implements Statistic {
    private final AtomicLong count = new AtomicLong(0);
    private final AtomicLong sum = new AtomicLong(0);
    private final AtomicInteger minimum = new AtomicInteger(Integer.MAX_VALUE);
    private final AtomicInteger maximum = new AtomicInteger(Integer.MIN_VALUE);
    private final AtomicReference<Double> sumOfSquares = new AtomicReference<>(0.0);

    @Override
    public void event(int value) {
        count.incrementAndGet();
        sum.addAndGet(value);
        minimum.set(Math.min(minimum.get(), value));
        maximum.set(Math.max(maximum.get(), value));

        double squaredValue = value * value;
        sumOfSquares.updateAndGet(oldValue -> oldValue + squaredValue);
    }

    @Override
    public float mean() {
        long currentCount = count.get();
        if (currentCount == 0) {
            return 0.0f;
        }
        return (float) sum.get() / currentCount;
    }

    @Override
    public int minimum() {
        return minimum.get();
    }

    @Override
    public int maximum() {
        return maximum.get();
    }

    @Override
    public float variance() {
        long currentCount = count.get();
        if (currentCount == 0) {
            return 0.0f;
        }

        double currentSum = sum.get();
        double currentSumOfSquares = sumOfSquares.get();

        float mean = (float) (currentSum / currentCount);
        return (float) (currentSumOfSquares / currentCount - mean * mean);
    }
}

class Main {
    private static final int NUM_THREADS = 5;
    private static final int NUM_SAMPLES_PER_THREAD = 1000;

    public static void main(String[] args) throws InterruptedException {
        Statistic statistic = new StatisticImplAtomic();
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(() -> {
                Random random = new Random();
                for (int j = 0; j < NUM_SAMPLES_PER_THREAD; j++) {
                    int value = random.nextInt(100);
                    statistic.event(value);
                }
            });
            threads[i].start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }

        // Display the calculated statistics
        System.out.println("Mean: " + statistic.mean());
        System.out.println("Minimum: " + statistic.minimum());
        System.out.println("Maximum: " + statistic.maximum());
        System.out.println("Variance: " + statistic.variance());
    }
}
