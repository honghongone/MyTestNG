package Demo1;

/**
 * 1:Thread.currentThread();当前线程，是一个静态方法，写在哪个线程体里面就代表哪个线程，写在main方法中就表示main线程
 * getName()：获取名称
 * setName()：设置名称
 * isAlive()：判断线程状态
 */
public class MyInfoThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread1=new MyThread1();
        Thread proxy=new Thread(myThread1);
        proxy.setName("first thread");
        System.out.println(proxy.getName());
        System.out.println(Thread.currentThread().getName());//main线程
        proxy.start();
        System.out.println("启动后线程的状态："+proxy.isAlive());
        Thread.sleep(200);
        myThread1.stop();
        Thread.sleep(200);
        System.out.println("停止后线程的状态："+proxy.isAlive());

    }
}
