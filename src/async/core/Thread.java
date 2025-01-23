package async.core;

public class Thread implements Runnable {
    private String name;
    private Executions.ThreadExecution execution;
    private java.lang.Thread thread;
    private ThreadParent parent;

    public Thread(Executions.ThreadExecution execution, ThreadParent parent, String name) {
        this.execution = execution;
        this.parent = parent;
        this.name = name;
    }

    public Thread start() {
        thread = new java.lang.Thread(this, name);
        thread.start();
        return this;
    }
    public void run() {
        execution.run(parent.getThreadNumber(this));
    }

    public String getName() {
        return name;
    }
}
