package async.core;

public class Executions {
    @FunctionalInterface
    public interface Execution {
        public int run();
    }
    @FunctionalInterface
    public interface ThreadExecution {
        public void run(int threadNumber);
    }
    @FunctionalInterface
    public interface AsyncExecution {
        public void run(Async async, int threadNumber);
    }
}
