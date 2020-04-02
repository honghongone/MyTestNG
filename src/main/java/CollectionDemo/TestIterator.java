package CollectionDemo;


import java.util.*;

/**
 * 测试迭代器的方法
 */
public class TestIterator {

    public static void main(String[] args) {
        List list=new ArrayList();
        list.add("12");
        list.add("ww");
        list.add("qw");
        //通过for循环来遍历List
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        System.out.println("-------------" );
        Iterator it=list.iterator();
        //通过迭代器来遍历List
        while(it.hasNext()){
            System.out.println(it.next());
        }


        Set set=new HashSet();
        set.add("23");
        set.add("sss");
        set.add("cc");
        Iterator iterator=set.iterator();
        //通过迭代器来遍历Set
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //迭代器也可以使用for循环来遍历Set
//        for(Iterator iterator=set.iterator();iterator.hasNext();){
//            System.out.println(iterator.next());
//
//        }
    }
}
