package Demo1.ThreadTest;

public class SybTest3 {
    public static void main(String[] args) {
        Object goods=new Object();
        Object money=new Object();
        Test test=new Test(goods,money);
        Test2 test2=new Test2(goods,money);//两个对象使用的是同一份资源

        Thread thread1=new Thread(test);
        Thread thread2=new Thread(test2);

        thread1.start();
        thread2.start();
    }
}

class Test implements Runnable{
    Object goods;
    Object money;

    public Test(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
         while (true){
             test();
         }
    }

    public void test(){
        synchronized (goods){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (money){
            }
        }
        System.out.println("一手给钱");

    }

}

class Test2 implements Runnable{
    Object goods;
    Object money;

    public Test2(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while (true){
            test();
        }
    }

    public void test(){
        synchronized (money){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (goods){
            }
        }
        System.out.println("一手给钱");

    }

}

