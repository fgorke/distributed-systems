package woche1;

class CounterDemo {
    public static void main(String[] args) throws InterruptedException {
        CounterThreads.testCounter();
        System.out.println("--------------------");
        CounterThreads.testSyncCounter();
    }
}

class Counter {
    private int c = 0;

    public void increment() {
        int b = c;
        b++;
        c = b;
    }

    public void decrement() {
        int d = c;
        d--;
        c = d;
    }

    public int value() {
        return c;
    }
}


class SyncCounter {
    private int c = 0;

    public synchronized void increment() {
        int b = c;
        b++;
        c = b;
    }

    public synchronized void decrement() {
        int d = c;
        d--;
        c = d;
    }

    public synchronized int value() {
        return c;
    }
}

class CounterThreads {

    static void testCounter() throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.decrement();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Counter: " + counter.value());
    }

    static void testSyncCounter() throws InterruptedException {
        SyncCounter syncCounter = new SyncCounter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                syncCounter.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                syncCounter.decrement();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("SyncCounter: " + syncCounter.value());
    }
}
