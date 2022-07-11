package threadtest.printwiththreethreads.oddeventwothreds;

public class ResourceClass {
    public int counter=1;
    public static void main(String []args)
    {
       ResourceClass resourceClass = new ResourceClass();

       Thread t1= new ThreadBase("T1",resourceClass);
       Thread t2 = new ThreadBase("T2",resourceClass);
       t1.start();
       t2.start();
       }
}
