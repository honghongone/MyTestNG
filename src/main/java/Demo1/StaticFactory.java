package Demo1;
/**
 * 实现静态代理模式需要满足下面三个条件：
 * 1：有真正的角色
 * 2：有代理角色：持有真实角色的引用
 * 3：两个角色需要实现同一个接口
 */
public class StaticFactory {
    public static void main(String[] args) {
        //创建真实角色
        You you=new You();
        //创建代理角色+真实角色的引用
        MarryCompany marryCompany=new MarryCompany(you);
        //可以看到真正干活执行的方法还是真实角色中的方法
        marryCompany.marry();



    }
}
//共同接口
interface Marry{
    public abstract void marry();
}
//真实角色
class You implements Marry{

    @Override
    public void marry() {
        System.out.println("you and嫦娥结婚");
    }
}
//代理角色
class MarryCompany implements Marry{
    private Marry you;
    public MarryCompany() {
    }

    public MarryCompany(Marry you) {
        this.you = you;
    }

    public Marry getYou() {
        return you;
    }

    public void setYou(Marry you) {
        this.you = you;
    }
    public void before(){
        System.out.println("准备工作");
    }
    public void after(){
        System.out.println("事后处理");
    }

    @Override
    public void marry() {
       before();
       you.marry();
       after();
    }
}