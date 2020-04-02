package Demo1;

/**
 * yield暂停线程
 */
public class YieldDemo01 extends Thread {
    public static void main(String[] args) throws InterruptedException {
        YieldDemo01 demo02=new YieldDemo01();
        Thread thread=new Thread(demo02);//新生状态
        thread.start();//就绪状态
        //cpu调度到变为运行状态
        for(int i=0;i<100;i++){
            if(i%3==0){
                //Thread.yield写在谁的线程体里面就是暂停谁的线程，现在是暂停main线程
                Thread.yield();
            }
            System.out.println("main......"+i);
        }
    }
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("yield....."+i);
        }

    }
}
