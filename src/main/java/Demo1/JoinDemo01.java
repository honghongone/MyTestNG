package Demo1;

/**
 * join合并线程
 */
public class JoinDemo01 extends Thread {
    public static void main(String[] args) throws InterruptedException {
        JoinDemo01 demo01=new JoinDemo01();
        Thread thread=new Thread(demo01);//新生状态
        thread.start();//就绪状态
        //cpu调度到变为运行状态
        for(int i=0;i<100;i++){
            if(i==50){
                thread.join();//合并线程，需要把demo01的run中的线程体全部执行完毕程序才可以往下走，也就是这个时候main线程阻塞了
            }
            System.out.println("main......"+i);
        }
    }
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("join....."+i);
        }

    }
}
