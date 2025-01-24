package async.launch;

import async.core.Async;

public class Main {
    static long lastTime = 0;
    static int seconds = 0;

    public static void main(String[] args) throws InterruptedException {
        Async m1 = new Async((Async async, int threadNumber) -> {
            while (seconds < 10 * (threadNumber + 1)) {
                if (System.nanoTime() - lastTime > 1000000000) {
                    seconds++;
                    System.out.println("1 second passed on thread " + threadNumber + ". Second " + seconds);
                    lastTime = System.nanoTime();
                    if (seconds > 5) {
                        async.desync();
                    }
                }
            }
        });
        m1.sync();
        m1.dispatch();
        m1.dispatch();
    }
}