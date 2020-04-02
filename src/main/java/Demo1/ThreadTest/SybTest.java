package Demo1.ThreadTest;

public class SybTest {
    public static void main(String[] args) {
        //创建真实角色
        web123062 web=new web123062();
        //创建代理角色+传入真实角色的引用,将代理角色的线程名取为路人甲
        Thread t1=new Thread(web,"路人甲");
        Thread t2=new Thread(web,"路人乙");
        Thread t3=new Thread(web,"黄牛");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}

class web123062 implements Runnable {
    private int num = 10;
    private boolean flag=true;

    @Override
    public void run() {
        while (flag) {
          test3();
        }
        //Thread.currentThread()获取当前线程
    }
//线程不安全
    public void test1(){
        if (num <= 0) {
            flag=false;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了" + num--);

    }
//线程安全
    public synchronized void test2(){
        if (num <= 0) {
            flag=false;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了" + num--);

    }
    //线程安全，锁定正确
    public void test3(){
        synchronized (this){
            if (num <= 0) {
                flag=false;
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
        }
    }
}
