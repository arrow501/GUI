import java.util.ArrayList;
import java.util.List;

public class Letters {
    private List<Thread> threads;

    private class LetterWriter extends Thread {
        private char letter;

        public LetterWriter(char letter) {
            this.letter = letter;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(letter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public Letters(String letters) {
        this.threads = new ArrayList<>();

        for (char letter : letters.toCharArray()) {
            threads.add(new LetterWriter(letter));
        }
    }

    public List<Thread> getThreads() {
        return threads;
    }

}
