package Demo1;

/**
 * 生产者消费者模式：信号灯法
 */
public class Movie {
    private String pic;
    //信号灯，如果是true则生产者生产消费者等待，生产完成后通知消费，如果是false则生产者等待消费者生产，消费完成后则通知生产
    private boolean flag=true;
    //播放
    public synchronized void play(String pic){
        if(!flag){//如果是false则生产者等待,消费者生产
            try{
                this.wait();//wait释放锁
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        //开始生产
        try{
            Thread.sleep(500);

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("生产了："+pic);
        //生产完毕
        this.pic=pic;
        //通知消费者消费
        this.notify();
        //生产者停止
        this.flag=false;
    }

    public synchronized void watch(){
        if(flag){//如果是true则消费者等待
            try{
                this.wait();//wait释放锁
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //开始消费
        try{
            Thread.sleep(200);

        }catch (Exception e){
            e.printStackTrace();
        }
        //消费完毕
        System.out.println("消费了"+pic);
        //通知生产者生产
        this.notify();
        //消费者停止
        this.flag=true;
    }
}
