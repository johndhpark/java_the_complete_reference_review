// A correct implementation of a producer and consuymer.

class Q {
    int n;
    boolean valueSet = false;

    synchronized int get(String str) {
        while (!valueSet && !isComplete()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InteruptedException caught");
            }
        }

        System.out.println(str + " got: " + n);
        valueSet = false;

        notifyAll();

        return n;
    }

    synchronized void put(int n) {
        while (valueSet && !isComplete()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }

        this.n = n;
        valueSet = true;

        System.out.println("Put: " + n);
        notifyAll();
        return;
    }

    public boolean isComplete() {
        return this.n == 49;
    }
}

class Producer implements Runnable {
    Q q;
    Thread t;

    public Producer(Q q) {
        this.q = q;
        t = new Thread(this);
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            q.put(i);
        }

        return;
    }
}

class Consumer implements Runnable {
    String str;
    Q q;
    Thread t;

    public Consumer(Q q, String str) {
        this.q = q;
        this.str = str;
        t = new Thread(this);

        System.out.println(str + " has been initiated.");
    }

    public void run() {
        while (!q.isComplete()) {
            q.get(str);
        }

        return;
    }
}

class PCFixed2 {
    public static void main(String[] args) {
        Q q = new Q();
        Producer p = new Producer(q);
        Consumer c1 = new Consumer(q, "Consumer One");
        Consumer c2 = new Consumer(q, "Consumer Two");
        Consumer c3 = new Consumer(q, "Consumer Three");

        // Start the threads
        p.t.start();
        c1.t.start();
        c2.t.start();
        c3.t.start();

        System.out.println("Press Control-C to stop");

        try {
            p.t.join();
            c1.t.join();
            c2.t.join();
            c3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrrupted");
        }

        System.out.println("Exiting main thread.");
    }
}