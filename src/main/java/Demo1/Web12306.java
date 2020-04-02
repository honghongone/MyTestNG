package Demo1;

/**
 * 用多线程实现的抢票系统
 */
public class Web12306 implements Runnable {
    private int num=50;
    @Override
    public void run() {
        while(true){
            if(num<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"抢到了"+num--);

        }
        //Thread.currentThread()获取当前线程
    }

    public static void main(String[] args) {
        //创建真实角色
        Web12306 web=new Web12306();
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
