package Demo1;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("匿名类运行");
            }
        },new Date(System.currentTimeMillis()+1000),200);//从当前时间往后1000毫秒开始运行，每隔200毫秒执行一次
    }
}
