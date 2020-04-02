package CollectionDemo;

/**
 * 实现自己的map
 * 暂时不完美，因为目前写的几个方法里面都需要遍历，效率太低，需要优化
 * map：就是存放键值对，通过健来找值，健不能重复
 */
public class MyMapFirst {

    private int size;
    Mymap[] arrs=new Mymap[88];

    public void put(Object key,Object value){
        Mymap mymap=new Mymap(key,value);
        for(int i=0;i<size;i++){
            if(arrs[i].getKey().equals(key)){
                arrs[i].setValue(value);//如果已经存在了key则直接覆盖
                return;
            }
        }
        arrs[size++]=mymap;
    }

    public Object get(Object key){

        for(int i=0;i<size;i++){
            if(arrs[i].getKey().equals(key)){
                return arrs[i].getValue();
            }
        }
        return null;
    }

    public boolean containKey(Object key){
        for(int i=0;i<size;i++){
            if(arrs[i].getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean containValue(Object value){
        for(int i=0;i<size;i++){
            if(arrs[i].getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyMapFirst map=new MyMapFirst();
        map.put("zs",new Wife("1"));
        map.put("ll",new Wife("22"));
        map.put("ll",new Wife("25"));
        Wife wife=(Wife) map.get("ll");
        System.out.println(wife.getName());
    }

}

class Mymap{
    private Object key;
    private Object value;

    public Mymap() {

    }
    public Mymap(Object key, Object value) {
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
