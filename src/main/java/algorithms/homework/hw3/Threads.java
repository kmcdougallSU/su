package algorithms.homework.hw3;

import java.util.logging.Logger;

public class Threads extends Thread {
    private static final Logger LOGGER = Logger.getLogger(Threads.class.getName());

    public static void main(String[] args) {
        LOGGER.info("you are stinky");

        Thread t1 = new Thread();
        t1.start();
    }
}

