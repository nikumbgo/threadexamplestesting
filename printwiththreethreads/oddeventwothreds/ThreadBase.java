package threadtest.printwiththreethreads.oddeventwothreds;

public class ThreadBase extends Thread {
    String name;
    ResourceClass resource;

    ThreadBase(String name, ResourceClass resource) {
        this.name = name;
        this.resource = resource;
    }

    @Override
    public void run() {

        while (this.resource.counter <= 100) {
            synchronized (this.resource) {
                if ((this.resource.counter % 2 == 0 && this.name.equalsIgnoreCase("T1")) ||
                        (this.resource.counter % 2 != 0 && this.name.equalsIgnoreCase("T2"))) {
                    try {

                        this.resource.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.println(this.name + "  " + this.resource.counter++);
                    this.resource.notifyAll();
                }

            }


        }


    }
}
