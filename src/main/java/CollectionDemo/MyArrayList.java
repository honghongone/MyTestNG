package CollectionDemo;


import java.util.ArrayList;
import java.util.List;

/**
 * 自己实现一个arrayList,帮助我们更好的理解ArrayL1st类的底层结构!
 * 本来应该是要继承Collection接口的，但是因为继承了就需要重写Collection里面所有的方法为了省事我们就先不继承
 */
public class MyArrayList {
    private Object[] elementData;
    private int size;

    public int size(){
        return size;
    }

    public MyArrayList(){
        this(10);
    }

    public MyArrayList(int initialCapacity)  {
        if(initialCapacity<0){
            try{
                throw new Exception();
            }
            catch (Exception e){
                e.printStackTrace();
            }

    }
        elementData=new Object[initialCapacity];



    }
    //数组扩容
    private void ensureCapacity(){
        //对elementData数组扩容，因为elementData数组初始是10个的如果要放超过10个就会越界了，那就需要扩容
        //说白了对数组的扩容其实就是重新定义个容量大一点的数组，因为数组一旦初始化了大小就不能再改变，所以只能重新new一个新的数组
        if(size>=elementData.length){
            Object[] newob=new Object[size*2];
            //System.arraycopy方法是数组拷贝，里面的参数分别是原数组elementData，从0开始拷贝，拷贝到数组newob，从0开始拷贝，拷贝的长度为原数组的长度
            System.arraycopy(elementData,0,newob,0,elementData.length);
            elementData=newob;
        }
    }

    public void add(Object o){
        ensureCapacity();
        elementData[size]=o;//将元素赋值给第size的位置
        size++;//然后size+1
    }

    public boolean isEmpty(){
        return size==0;
    }
    private void rangeCheck(int index)  {
        if(index<0||index>=size){
            try{
                throw new Exception();
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public Object get(int index)  {
        rangeCheck(index);
        return elementData[index];
    }



    public void remove(int index)  {

        rangeCheck(index);
        //假设数组长度为5，如果要移除的位置是2，则numMoved就是2
        int numMoved = size - index - 1;
        if (numMoved > 0)
            //System.arraycopy数组拷贝，
            // 表示将elementData数组从index+1的位置开始拷贝，拷贝到elementData数组中index开始的位置，拷贝的元素个数是numMoved个，也就是向前移动了一位
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        //因为移除了一位所以要先将原来的size的值减一，减一了之后再将最后的元素值设置为null
        elementData[--size] = null; // clear to let GC do its work
    }


    public void remove(Object obj)  {
        for(int i=0;i<size;i++){
            if(elementData[i].equals(obj)){
                remove(i);
            }
        }
    }

    public Object set(int index,Object obj)  {
        rangeCheck(index);
        Object oldValue = elementData[index];
        elementData[index] = obj;
        return oldValue;
    }

    public void add(int index,Object obj)  {
        rangeCheck(index);
        ensureCapacity();
        //System.arraycopy方法这里表示将elementData数组从index位置开始，拷贝到elementData数组的index + 1的位置开始，拷贝个数是size - index
        //比如说["a","b","c","d","e"]要在索引为2的位置添加一个元素，操作就是将数组从c元素开始拷贝到d开始的位置，拷贝的个数是5-2=3，这样的话也就是空出了index的位置
        //然后将要添加的值放到index的位置即可elementData[index] = obj;
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = obj;
        size++;
    }



    public static void main(String[] args)  {
        MyArrayList list=new MyArrayList(3);//为了测试add方法直接先初始化MyArrayList中的数组长度为3
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("aaa");
        list.add("ccc");
        list.add("ddd");
        list.add("112");
        list.add("wee");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(5));
        System.out.println(list);
        System.out.println(list.get(2));
        list.remove(2);
        System.out.println(list.get(2));

        System.out.println(list);

    }

}
