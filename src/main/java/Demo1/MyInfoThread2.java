package Demo1;

/**
 setPriority//设置优先级
 */
public class MyInfoThread2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread1=new MyThread1();
        Thread proxy=new Thread(myThread1,"it1");
        MyThread1 myThread2=new MyThread1();
        Thread proxy2=new Thread(myThread1,"it2");

        proxy.setPriority(Thread.MAX_PRIORITY);//设置优先级
        proxy.setPriority(Thread.MIN_PRIORITY);
        proxy.start();
        proxy2.start();

        Thread.sleep(500);

        myThread1.stop();
        myThread2.stop();


    }
}
