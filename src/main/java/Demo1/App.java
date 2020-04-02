package Demo1;

public class App {
    public static void main(String[] args) {
        Movie movie=new Movie();//共同的资源
        Player player=new Player(movie);
        Watcher watcher=new Watcher(movie);//多线程
        new Thread(player).start();
        new Thread(watcher).start();
    }
}
