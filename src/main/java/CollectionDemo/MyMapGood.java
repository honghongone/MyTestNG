package CollectionDemo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 自定义map的升级版
 * 1:提高查询效率，hashCode方法是根据对象的地址计算出一个数值
 */

public class MyMapGood extends Object{
    LinkedList[] arrs=new LinkedList[999];
    private int size;

    public int size(){
        return size;
    }
    public void put(Object key,Object value){
        Mymap2 keyval=new Mymap2(key,value);
        int a=key.hashCode()%arrs.length;
        if(arrs[a]==null){
            LinkedList linkedList=new LinkedList();
            arrs[a]=linkedList;
            linkedList.add(keyval);
        }
        else {
            LinkedList list=arrs[a];
            for(int i=0;i<list.size();i++){
                Mymap2 m=(Mymap2) list.get(i);
                if(m.getKey().equals(key)){
                    m.setValue(value);//如果键已经存在则直接覆盖
                    return;
                }
            }

            arrs[a].add(keyval);
        }
        size++;
    }

    public Object get(Object key){
        int a=key.hashCode()%arrs.length;
        if(arrs[a]!=null){
            LinkedList list=arrs[a];
            for(int i=0;i<list.size();i++){
                Mymap2 m=(Mymap2) list.get(i);
                if(m.getKey().equals(key)){
                    return m.getValue();
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        MyMapGood myMapGood=new MyMapGood();
        myMapGood.put("ll","12");
        myMapGood.put("ls","23");
        myMapGood.put("ll","24");
        myMapGood.put("ss","2222");

        System.out.println(myMapGood.get("ll"));
        System.out.println(myMapGood.size());

    }

}

class Mymap2{
    private Object key;
    private Object value;

    public Mymap2() {

    }
    public Mymap2(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

