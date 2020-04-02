package Demo1.ThreadTest;

/**
 * 单例设计模式：确保一个类只有一个对象
 */
public class SybTest2 {
    public static void main(String[] args) {
        JvmThread jvmThread1=new JvmThread(100);
        JvmThread jvmThread2=new JvmThread(200);
        jvmThread1.start();
        jvmThread2.start();


    }
}
//创建一个线程类用来模拟多线程
class JvmThread extends Thread{
    private long time;
    public JvmThread() {
    }
    public JvmThread(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建对象："+Jvm.getInstance3(time));
    }
}
//确保一个类只有一个对象
//懒汉式写法
class Jvm{
    //第一步构造器私有化,避免外部直接创建对象
     private Jvm(){}
    //第二步声明一个私有的静态变量
     private static Jvm instance=null;//这里不创建对象下面使用的时候在方法里面再创建对象所以叫懒汉式
     //第三步创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
    public static synchronized Jvm getInstance(long time){
        if(null==instance){
        try {
            Thread.sleep(time);//增加延时看效果
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        instance=new Jvm();
    }
        return instance;
     }

    public static  Jvm getInstance2(long time){
        synchronized (Jvm.class){
            if(null==instance){
                try {
                    Thread.sleep(time);//增加延时看效果
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance=new Jvm();
            }
            return instance;
        }

    }


    public static  Jvm getInstance3(long time){
        if(null==instance){//提高效率，如果已经存在对象则不需要等待不需要进入到同步代码块中直接返回已经存在的对象即可
            synchronized (Jvm.class){
                if(null==instance){
                    try {
                        Thread.sleep(time);//增加延时看效果
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance=new Jvm();
                }
                return instance;
            }
        }
        return instance;

    }
}

class Jvm3{
    private static class jvm4{
        private static Jvm3 instance=new Jvm3();
    }
    private  Jvm3(){}
    public static Jvm3 getInstance(){
        return jvm4.instance;
    }
}

