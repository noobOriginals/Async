package async.core;

import java.util.ArrayList;

public class Async implements ThreadParent {
    private Executions.ThreadExecution execution;
    private ArrayList<Thread> threads;

    public Async(Executions.ThreadExecution execution) {
        this.execution = execution;
    }

    public void dispatch() {
        threads.add(new Thread(execution, this, "AsyncThread" + threads.size()).start());
    }

    public int getThreadNumber(Thread thread) {
        return 0;
    }
}