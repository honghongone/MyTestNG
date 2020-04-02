package CollectionDemo;

/**
 * 迭代器简单版
 */
public class MyIterator1 {

    private String[] elem={"1","2","3","4","5"};
    private int size=elem.length;

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

    public static void main(String[] args) {
        MyIterator1 myIterator1=new MyIterator1();
        while (myIterator1.hasNext()){
            System.out.println(myIterator1.next());
        }

        myIterator1=new MyIterator1();
        while (myIterator1.hasNext()){
            System.out.println(myIterator1.next());
        }
    }
}
