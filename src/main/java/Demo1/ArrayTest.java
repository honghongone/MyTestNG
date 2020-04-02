package Demo1;

import java.util.ArrayList;

public class ArrayTest {

    public static void main(String[] args) {
        Integer[] arr=new Integer[4];
        //没有范型数组，可以看到声明时可以使用，创建的时候报错，new Student4<String>[10]的时候报错
        //Student4<String>[] stuarr=new Student4<String>[10];
        //但是可以通过下面的方式来写
        Student4<?>[] stuarr2=new Student4[10];//但是这种写法没有意义，因为范型数组是不存在的
        //看下如何使用自定义的类来实现范型数组
        myArrayList<String> strarry=new myArrayList<String>();
        strarry.add(0,"hello");
        String st=strarry.getElem(0);
        System.out.println(st);


    }
}
//自定义类来实现范型数组功能
class myArrayList<E>{
    //E[] a=new E[10];这样写是错误的，因为没有范型数组
    Object[] cap=new Object[10];

    public void add(int index,E e){
        cap[index]=e;
    }

    public E getElem(int index){
        return (E)cap[index];
    }

    public E[] getAll(){
        return (E[])cap;
    }
}
