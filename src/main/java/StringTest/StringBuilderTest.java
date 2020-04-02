package StringTest;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb1=new StringBuilder();//空构造器是创建长度为16的字符数组
        StringBuilder sb2=new StringBuilder(32);//创建长度为32的字符数组
        StringBuilder sb3=new StringBuilder("hello");//创建了长度为5+16也就是21的字符数组

        sb2.append(true).append("wode");
        //源码的append方法写了return this，可以实现方法链
        System.out.println(sb2);

        StringBuilder s=new StringBuilder("a");
        //在堆中创建了两个对象（一个是在堆的常量池中"a",一个是在堆中的new StringBuilder这个对象）
        //在栈中创建了一个StringBuilder s引用变量
        for(int i=0;i<1000;i++){
            s.append(i);
        }

        System.out.println(s);

        String str=new String("aabb");
        //在堆的常量池中创建了1001个对象，在堆中创建了一个对象new String
        //在栈中创建了一个引用变量str
        for(int i=0;i<1000;i++){
            str+=i;
        }
        System.out.println(str);

    }
}
