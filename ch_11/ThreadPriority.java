// Create a class that implements the Runnable interface

class NewThread implements Runnable {
    String name;
    Thread t;

    NewThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " Interrupted");
        }

        System.out.println(name + " exiting.");
    }
}


class ThreadPriority {
    public static void main(String[] args) {
        NewThread nt1 = new NewThread("One");
        NewThread nt2 = new NewThread("Two");
        NewThread nt3 = new NewThread("Three");

        System.out.println(nt1.name + " priority level is " + nt1.t.getPriority());
        System.out.println(nt2.name + " priority level is " + nt2.t.getPriority());
        System.out.println(nt3.name + " priority level is " + nt3.t.getPriority());

        // nt3.t.setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.MAX_PRIORITY);

        System.out.println(nt3.name + " priority level is " + nt3.t.getPriority());

       nt1.t.start();
       nt2.t.start();
       nt3.t.start();

       try {
           nt1.t.join();
           nt2.t.join();
           nt3.t.join();
       } catch (InterruptedException e) {
           System.out.println("Main thread interrupted.");
       }

       System.out.println("Thread One is alive: " + nt1.t.isAlive());
       System.out.println("Thread Two is alive: " + nt2.t.isAlive());
       System.out.println("Thread Three is alive: " + nt3.t.isAlive());

    }
} 