package CollectionDemo;

import java.util.Iterator;

/**
 * 迭代器简单版,匿名内部类
 */
public class MyIterator3 implements Iterable<String>{

    private String[] elem={"1","2","3","4","0"};
    private int size=elem.length;

    //匿名内部类
    public Iterator<String> iterator(){
        return new Iterator<String>()
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
        };
    }

    public static void main(String[] args) {
        MyIterator3 myIterator3=new MyIterator3();
        Iterator<String> it=myIterator3.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }


        for(String str:myIterator3){

        }

    }
}
