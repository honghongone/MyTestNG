package Demo1;

/**
 * 使用Runnable接口创建线程
 * 1：类实现Runnable接口+重写run方法，这个就是我们的真实角色类
 * 2:启动多线程 使用静态代理，步骤：
 *                  1：创建真实角色
 *                  2：创建代理角色+真实角色的引用
 *                  3：调用.start()方法启动线程
 */
public class Programmer implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println("一边敲hello world");
        }
    }
}
