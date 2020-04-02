package CollectionDemo;

import java.util.*;

/**
 * 测试List常用的方法
 */
public class TestList {


    public static void main(String[] args) {
        List list1=new ArrayList();
        list1.add("sttt");//可以放字符串
        list1.add(new Date());//可以放对象
        list1.add(new Dog());
        //这里有人有问题1234是数字，不是对象怎么也能放进去，
        // 原因是因为包装类的自动装箱，在程序编译的时候将1234自动转换成了Integer的对象
        list1.add(1234);//可以放数字
        //这里还有一个问题这里的这个list1的长度和ArrayList里面定义的数组的长度是不一样的，可以去看下源码
        System.out.println(list1);
        list1.remove("sttt");//可以看到这里移除的"sttt"和上面的list1.add("sttt")是同一个对象，所以就是容器里面移除了"sttt"，长度就减一了
        list1.remove(new Date());
        //可以看到这里的new Date()对象和上面的new Date()对象是两个不同的对象，
        // 老师说虽然是不同的两个对象，但是删除的时候也会把原来容器中的new Date()对象给删除了，原因是因为hashmap()和equals()方法，但是奇怪的是我试了一下并没有删除
        System.out.println(list1);
        System.out.println(list1.size());

        List list2=new ArrayList();
        list2.add("bbb");
        list2.add("ccc");
        list1.add(list2);//可以看到add是直接将列表放入
        System.out.println(list1);
        list1.addAll(list2);//可以看到addall是将列表中每个元素依次放入
        System.out.println(list1);
        String str=(String) list1.get(0);//get方法返回的是object所以需要强制转换
        System.out.println(str);
        list1.set(1,"222");
        System.out.println(list1);
        list1.remove(0);//移除某个索引对应的值
        System.out.println(list1);


    }

}
class Dog{
    public static void main(String[] args) {
        List list=new ArrayList();
        //注意下如果这里的List list=new ArrayList()改为Collection list=new ArrayList()是不行的，
        // 原因：可以看到下面get方法就无法调用了，原因就是Collection里面没有get方法
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        System.out.println(list);
        String str=(String) list.get(0);
        System.out.println(str);
        System.out.println(list.remove(new String("aaa")));
        System.out.println(list);

    }
}