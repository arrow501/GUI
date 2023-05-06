import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer(10);

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                producerThread.interrupt();
                consumerThread.interrupt();

                cancel();
                System.exit(0);
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 15 * 1000);
    }
}

class Message {
    private int id;
    int data;

    public Message(int id, int data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public int getData() {
        return data;
    }
}

class Buffer {

    private Message[] array;
    private int size;
    private int capacity;
    private int head;
    private int tail;

    public Buffer(int capacity) {
        this.capacity = capacity;
        array = new Message[capacity];
        size = 0;
        head = 0;
        tail = -1;
    }

    public synchronized void put(Message message) throws InterruptedException {

        while (size == capacity) {
            wait();
        }

        tail = (tail + 1) % capacity;

        array[tail] = message;

        size++;

        notifyAll();
    }

    public synchronized Message get() throws InterruptedException {

        while (size == 0) {
            wait();
        }

        Message message = array[head];

        head = (head + 1) % capacity;

        size--;

        notifyAll();

        return message;
    }
}

class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int id = 0;
        while (true) {
            try {

                int data = (int) (Math.random() * 100);

                Message message = new Message(id, data);

                buffer.put(message);

                System.out.println("Producer produced " + message.getId() + " with data " + message.getData());

                id++;

                Thread.sleep((long) (Math.random() * 2000));
            } catch (InterruptedException e) {
                System.out.println("Producer has stopped.");
                return;
            }
        }
    }
}

class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {

                Message message = buffer.get();

                System.out.println("Consumer consumed " + message.getId() + " with data " + message.getData());

                Thread.sleep((long) (Math.random() * 2000));
            } catch (InterruptedException e) {
                System.out.println("Consumer has stopped.");
                return;
            }
        }
    }
}
