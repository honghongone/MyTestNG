package Demo1;

import java.io.Closeable;
import java.io.IOException;

/**
1:public static <T> void test1(T a)范型方法中<>必须在返回类型前面
 2:范型方法中只能访问对象的信息，不能修改对象的信息
 */
public class Student3 {
    public static <T> void test1(T a)
    {//范型方法
        System.out.println(a);
    }

    public static <T extends Closeable> void test2(T...  t){//T...表示可变参数
        for(T temp:t){
            {
                try{
                    if(temp!=null)
                    temp.close();//这里只能使用对象temp，不能修改temp的值
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        test1("hello");
    }
}
