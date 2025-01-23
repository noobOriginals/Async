package async.core;

public class Executions {
    @FunctionalInterface
    public interface Execution {
        public int run();
    }
    @FunctionalInterface
    public interface ThreadExecution {
        public int run(int threadNumber);
    }
}
