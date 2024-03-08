package systems.homework.hw3;

import java.util.*;

public class Threads {

    public static void main(String[] args) throws InterruptedException {
        // ArrayList to hold generated random numbers
        List<Integer> numbers = new ArrayList<>();

        // Fill ArrayList
        for (int i = 0; i < 1000; i++) {
            numbers.add((int) ((Math.random() * 10000 + 1)));
        }

        // Sort list to find min and max value
        Collections.sort(numbers);

        // Runnable methods to pass to threads
        Runnable calculateAverage = () -> {
            double sum = 0;

            for (int n : numbers
            ) {
                sum += n;
            }
            System.out.printf("\nAverage value = %.2f\n", sum / numbers.size());
        };

        Runnable findMin = () -> {
            int min = numbers.get(0);
            System.out.printf("Minimum value = %d\n", min);
        };

        Runnable findMax = () -> {
            int max = numbers.get(numbers.size() - 1);
            System.out.printf("Maximum value = %d\n", max);
        };

        Thread t1 = new Thread(calculateAverage);
        t1.start();
        t1.join();

        Thread t2 = new Thread(findMin);
        t2.start();
        t2.join();

        Thread t3 = new Thread(findMax);
        t3.start();
        t3.join();

        System.out.println("\nSorted list contents:");
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}

