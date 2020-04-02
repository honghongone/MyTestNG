package Demo1;

/**
 * 消费者观看
 */
public class Watcher implements Runnable{
    private Movie m;

    public Watcher(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            m.watch();
        }

    }
}
