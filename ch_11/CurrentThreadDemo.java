// Controlling the main thread

class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread ct = Thread.currentThread();

        System.out.println("Current thread: " + ct);

        // change the name of the thread
        ct.setName("My Thread");
        System.out.println("After name change: " + ct);

        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}