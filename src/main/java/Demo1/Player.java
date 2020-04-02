package Demo1;

/**
 * 生产者播放
 */
public class Player implements Runnable{
    private Movie m;

    public Player(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                m.play("还珠格格");
            }
            else {
                m.play("大头");
            }
        }
    }
}
