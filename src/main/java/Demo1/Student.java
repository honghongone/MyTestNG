package Demo1;

/**
 * 可以发现如果没有范型，我们在使用object定义属性类型的时候需要我们
 * 1：强制类型转换
 * 2：手动检查类型，避免类型转换错误ClassCastException
 * */
public class Student {
    private Object htmlScore;
    private Object javaScore;

    public Student(Object htmlScore, Object javaScore) {
        this.htmlScore = htmlScore;
        this.javaScore = javaScore;
    }

    public Object getHtmlScore() {
        return htmlScore;
    }

    public void setHtmlScore(Object htmlScore) {
        this.htmlScore = htmlScore;
    }

    public Object getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(Object javaScore) {
        this.javaScore = javaScore;
    }

    public static void main(String[] args) {
        //存入整数，这里发生了自动装箱，int-这里是自动装箱--Interge--这里发生了多态-->Object
        Student stu=new Student(80,90);
        //注意一下：jdk1.7以后支持Object直接转换成int，之前的话只能写成int htmlscore=(Integer)stu.getHtmlScore()
        int htmlscore=(int)stu.getHtmlScore();//需要我们强制类型转换
        //这里发生了Object转成Integer然后自动拆箱为int
        System.out.println(stu.getJavaScore() instanceof Integer);
        if(stu.getJavaScore() instanceof String){//需要我们手工检查
            String str=(String)stu.getJavaScore();
            //可以发现这里发生了运行时错误ClassCastException，也就是类型检查，所以就需要我们手工的做类型检查操作
        }
    }
}
