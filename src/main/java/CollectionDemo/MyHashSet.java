package CollectionDemo;


import java.util.HashMap;

/**
 * 自定义自己的HashSet
 */
public class MyHashSet {
    private HashMap map;

    private static final Object PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap<>();
    }
    public int size(){
        return map.size();
    }

    public void add(Object obj){
        map.put(obj,PRESENT);//set的不可重复就是利用了map里面键对象的不可重复

    }

    public static void main(String[] args) {
        MyHashSet set=new MyHashSet();
        set.add("aaa");
        set.add(new String("aaa"));
        set.add("sss");
        System.out.println(set.size());

    }
}
