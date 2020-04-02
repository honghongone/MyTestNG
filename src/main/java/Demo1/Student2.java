package Demo1;

/**
 * 1：范型类型只能是引用类型不能是基本类型，如：Student2<String,Integer>，不能是Student2<String,int>
 * 2：范型声明时字母不能使用在静态属性和静态方法上，原因是静态方法属性是在编译的时候就确定类型的，但是范型是在使用时才确定类型
 * 如private static T1 S;就是错误的
 * @param <T1>
 * @param <T2>
 */
public class Student2<T1,T2> {
    private T1 javaScore;
    private T2 htmlScore;

    public Student2() {

    }
    public Student2(T1 javaScore, T2 htmlScore) {
        this.javaScore = javaScore;
        this.htmlScore = htmlScore;
    }

    public static <T> void test1(T a){
        System.out.println(a);
    }

    public T1 getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(T1 javaScore) {
        this.javaScore = javaScore;
    }

    public T2 getHtmlScore() {
        return htmlScore;
    }

    public void setHtmlScore(T2 htmlScore) {
        this.htmlScore = htmlScore;
    }

    public static void main(String[] args) {
        //使用时指定类型（这个类型只能是引用类型不能是基本类型），也就是类型是在使用的时候确定的
        Student2<String,Integer> stu=new Student2<String,Integer>();
        //可以看到在set的时候程序自动显示方法setJavaScore(String javaScore)
        //也就是1：安全，帮我们做了类型检查，我们在设值的时候就只能设置string了
        stu.setJavaScore("90");
        stu.setHtmlScore(80);
        int htmls=stu.getHtmlScore();//2:类型自动转换，不需要我们手动转换

        test1("hello");
    }
}
