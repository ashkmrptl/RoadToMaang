package companies.paloaltonetworks.statics;

import java.util.Random;

public class StatisticImpl implements Statistic {
    private int count;
    private int sum;
    private int min;
    private int max;
    private double sumOfValueSquares;

    public StatisticImpl() {
        this.count = 0;
        this.sum = 0;
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
        this.sumOfValueSquares = 0.0;
    }

    @Override
    public synchronized void event(int value) {
        // Update statistics
        count++;
        sum += value;
        min = Math.min(min, value);
        max = Math.max(max, value);
        sumOfValueSquares += (value * value);
    }

    @Override
    public synchronized float mean() {
        if (count == 0) {
            return 0.0f;
        }
        return (float) sum / count;
    }

    @Override
    public synchronized int minimum() {
        return min;
    }

    @Override
    public synchronized int maximum() {
        return max;
    }

    @Override
    public synchronized float variance() {
        if (count == 0) {
            return 0.0f;
        }

        float mean = mean();
        return (float) (sumOfValueSquares / count - mean * mean);
    }
}

class Test {
    private static final int NUM_THREADS = 5;
    private static final int NUM_SAMPLES_PER_THREAD = 1000;

    public static void main(String[] args) throws InterruptedException {
        Statistic statistic = new StatisticImpl();
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