package Demo1;

import java.util.concurrent.*;

/**
 * 使用Callable创建线程
 */
public class Call {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程，创建了2个线程
        ExecutorService ser= Executors.newFixedThreadPool(2);
        Race torries=new Race("乌龟",1000);
        Race rabbit=new Race("兔子",500);

        //获取值
        //Future future=ser.submit(实现类对象);
        Future<Integer> result1=ser.submit(torries);
        Future<Integer> result2=ser.submit(rabbit);

        Thread.sleep(2000);
        torries.setFlag(false);//停止线程体循环
        rabbit.setFlag(false);

        int num1=result1.get();
        int num2=result2.get();

        System.out.println("乌龟跑了"+num1+"步");
        System.out.println("兔子跑了"+num2+"步");
        ser.shutdownNow();//停止服务
    }
}
//Callable<Integer>中的范型类型决定了call方法的返回值类型
class Race implements Callable<Integer>{
    private String name;
    private long time;
    private int step=0;
    private boolean flag=true;
    public Race() {
    }
    public Race(String name) {
        this.name = name;
    }

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
//Callable<Integer>中的范型类型决定了call方法的返回值类型

    @Override
    public Integer call() throws Exception {
        while(flag){
            Thread.sleep(time);//延时
            step++;
        }
        return step;
    }
}