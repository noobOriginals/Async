package async.core;

import java.util.ArrayList;

public class Async implements ThreadParent {
    private Executions.AsyncExecution execution;
    private ArrayList<Thread> threads;
    private boolean synced = false;

    public Async(Executions.AsyncExecution execution) {
        this.execution = execution;
        threads = new ArrayList<>();
    }

    public void dispatch() {
        threads.add(new Thread(this::execution, this, "AsyncThread" + threads.size()).start());
    }
    public void sync() {
        synced = true;
    }
    public void desync() {
        synced = false;
    }

    public int getThreadNumber(Thread thread) {
        String name = thread.getName();
        return Integer.parseInt(name.substring(name.lastIndexOf('d') + 1));
    }

    void execution(int threadNumber) {
        if (synced) {
            synchronized(this) {
                execution.run(this, threadNumber);
            }
        } else {
            execution.run(this, threadNumber);
        }
    }
}