package threadtest.printwiththreethreads;

public class ResourceClass extends Thread {
    BaseClass pcMain;
    int threadName;

    ResourceClass(int threadName, BaseClass pcMain) {
        this.threadName = threadName;
        this.pcMain = pcMain;
    }

    @Override
    public void run() {
        // System.out.println(this.threadName);
        while (this.pcMain.counter <= 100) {
            synchronized (pcMain) {
                if (pcMain.counter % 10 != threadName
                        && !(pcMain.counter % 10 == 0 && threadName == 10)) {
                    try {

                        pcMain.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {

                    System.out.println(pcMain.counter + " Thread  " + this.threadName);
                    pcMain.counter++;
                    pcMain.notifyAll();
                }
            }

        }
    }
}
