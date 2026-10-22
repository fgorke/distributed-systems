package woche1;

public class SimpleThreads {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread("" + i) {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Thread [" + getName() + "]: Schritt " + i);
                    }
                }
            }.start();
        }
    }
}
