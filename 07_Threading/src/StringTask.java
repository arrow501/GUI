public class StringTask implements Runnable {
    public enum State {
        CREATED,
        RUNNING,
        ABORTED,
        READY,
    }

    private String seed;
    private int repeats;

    private State state;
    private String result;

    private int repeatsDone;
    private Thread running;

    public StringTask(String seed, int repeats) {
        this.state = State.CREATED;

        this.seed = seed;
        this.repeats = repeats;
        this.result = "";

    }

    @Override
    public void run() {

        this.state = State.RUNNING;

        int i = 0;
        if (repeatsDone != 0)
            i = repeatsDone;
        try {

            for (; i < repeats; i++) {
                if (Thread.interrupted())
                    throw new InterruptedException();
                result = result + getReverseSeed();

            }
            state = State.READY;
        } catch (InterruptedException e) {
            repeatsDone = i;

            state = State.ABORTED;

        }

    }

    public boolean checkIntegrity() {
        return repeatsDone * seed.length() == result.length();
    }

    private String getReverseSeed() {
        String reverse = "";
        for (char c : seed.toCharArray()) {
            reverse = reverse + c;
        }
        return reverse;
    }

    public String getResult() {
        if (state == State.ABORTED)
            return result;
        return result;

    }

    public State getState() {
        return state;

    }

    public void start() {
        running = new Thread(this);
        running.start();
    }

    public void abort() throws InterruptedException {
        if (running != null) {
            running.interrupt();
            // System.out.println("aborted");
            // running.join();
        }
    }

    public boolean isDone() {
        if (state == State.READY)
            return true;

        if (state == State.ABORTED)
            return true;
        return false;

    }

    public String getTxt() {
        return seed;
    }

}
