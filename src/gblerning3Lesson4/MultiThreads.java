package gblerning3Lesson4;

public class MultiThreads {

    private final Object monitor = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {

        MultiThreads mt = new MultiThreads();



        Thread thread1 = new Thread(() -> {
            mt.echoA();
        });

        Thread thread2 = new Thread(() -> {
            mt.echoB();
        });
        Thread thread3 = new Thread(() -> {
            mt.echoC();
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }


    public void echoA() {
        synchronized (monitor){
            try {
                for(int x=0; x<5;x++){
                    while (currentLetter!='A') monitor.wait();
                }
                System.out.println("A");
                currentLetter='B';
                monitor.notify();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void echoB() {
        synchronized (monitor){
            try {
                for(int x=0; x<5;x++){
                    while (currentLetter!='B') monitor.wait();
                }
                System.out.println("B");
                currentLetter='C';
                monitor.notify();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void echoC() {
        synchronized (monitor){
            try {
                for(int x=0; x<5;x++){
                    while (currentLetter!='C') monitor.wait();
                }
                System.out.println("C");
                currentLetter='A';
                monitor.notify();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
