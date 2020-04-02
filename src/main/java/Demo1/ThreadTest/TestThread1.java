package Demo1.ThreadTest;

public class TestThread1 {

    public static void main(String[] args) {
        //使用多线程：第一步：创建子类对象
        Rabbit rabbit=new Rabbit();
        torries torries=new torries();
        //第二步：对象.start方法启动线程，也就是将该方法加入到线程组里面，注意不要自己调用run方法，run方法是程序内部自己会调用的
        rabbit.start();
        torries.start();
        //上面的代码就开辟了两个线程，可以看到目前就有三个线程了，main主线程，Rabbit线程，torries线程（当然还有后台的gc线程和异常机制线程）

        for(int i=0;i<1000;i++){
            System.out.println("main跑了"+i+"步");
        }
    }
}
