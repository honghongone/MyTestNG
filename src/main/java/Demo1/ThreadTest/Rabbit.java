package Demo1.ThreadTest;

/**
 * 模拟龟兔赛跑
 * 1：创建多线程，继承Thread类+重写run方法（里面的代码是线程体）
 * 2：使用多线程：第一步：创建子类对象,第二步：对象.start方法
 */
public class Rabbit extends Thread {
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println("兔子跑了"+i+"步");
        }
    }


}

class torries extends Thread{
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println("乌龟跑了"+i+"步");
        }
    }
}
