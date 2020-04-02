package Demo1;

public class HttpSelvet {
    public void doGet(){
        System.out.println("doget");

    }
    public void service(){
        System.out.println("service");
        doGet();
    }
}
