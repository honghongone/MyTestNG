package Demo1;


public class ProgrammerTest {
    public static void main(String[] args) {
        //1：创建真实角色
        Programmer programmer=new Programmer();
        //2：创建代理角色+真实角色的引用
        Thread proxy=new Thread(programmer);
        //3：调用.start()方法启动线程
        proxy.start();

        for (int i=0;i<1000;i++){
            System.out.println("一边聊qq");
        }


    }
}
