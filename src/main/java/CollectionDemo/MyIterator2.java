package CollectionDemo;

import java.util.Iterator;

/**
 * 迭代器简单版,加入接口实现
 */
public class MyIterator2 {

    private String[] elem={"1","2","3","4","0"};
    private int size=elem.length;

//实现Iterator接口
    private class Myiter implements Iterator<String>
{
    private int cursor=-1;

    public boolean hasNext(){
        return cursor+1<size;
    }

    public String next(){
        cursor++;
        return elem[cursor];
    }

    public void remove(){
//暂时不实现
    }
    }
    public Iterator<String> iterator(){
        return new Myiter();
    }

    public static void main(String[] args) {
        MyIterator2 myIterator2=new MyIterator2();
        Iterator<String> it=myIterator2.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        it=myIterator2.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
