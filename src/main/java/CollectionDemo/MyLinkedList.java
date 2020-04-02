package CollectionDemo;

public class MyLinkedList {

    private Node first;//定义头节点
    private Node last;//定义尾节点
    private Object obj;//节点存放的元素
    private int size;

    public int size(){
        return size;
    }
    public void add(Object obj){
        Node node=new Node();
        if(first==null){
            node.setPrevious(null);
            node.setNext(null);
            node.setObj(obj);
            first=node;
            last=node;
        }
        //直接往last节点后增加新的节点
        else {
            node.setPrevious(last);
            node.setObj(obj);
            node.setNext(null);
            last.setNext(node);
            last=node;

        }
        size++;
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

    //按索引找节点是这个链表最关键的部分
    public Node findNode(int index){
        Node temp=null;
        if(first!=null){
            temp=first;//一开始temp先指向first节点
            //假设有一个链表有aa,bb,cc三个节点，则aa就是索引0，bb就是索引1,cc就是索引2，如果要找1，那就是从first节点开始遍历链表，
            //每次遍历的时候i+1，也就是for循环里面的i++，同时将临时节点temp后移一位，直到i等于index的时候说明找到了我们要找的元素，这个时候的temp指向的节点正好是我们要找的节点
            for(int i=0;i<index;i++){
                temp=temp.getNext();//temp后移一位
            }
        }
        return temp;
    }

    public Object get(int index){
        rangeCheck(index);//先判断index是否合理
        Node temp=findNode(index);
        if(temp!=null){
            return temp.getObj();//返回temp所指节点的值
        }
        return null;
    }

    public void remove(int index){
        rangeCheck(index);
        Node temp=findNode(index);
        if(temp!=null){
            Node up=temp.getPrevious();
            Node down=temp.getNext();
            up.setNext(down);
            down.setPrevious(up);
            size--;
        }

    }

    public void add(int index,Object obj){
        rangeCheck(index);
        Node temp=findNode(index);
        Node newnode=new Node();
        newnode.obj=obj;
        if(temp!=null){
            Node up=temp.previous;
            newnode.previous=up;
            up.next=newnode;
            newnode.next=temp;
            temp.previous=newnode;
            size++;
        }
    }

    public void set(int index,Object obj){
        rangeCheck(index);
        Node temp=findNode(index);
        if(temp!=null){
            temp.obj=obj;
        }


    }

    public static void main(String[] args) {
        MyLinkedList linkedList=new MyLinkedList();
        linkedList.add("122");
        linkedList.add("aa");
        linkedList.add(1,"sss");
        linkedList.add("cc");
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));
        linkedList.set(3,"eee");
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.size());

    }
}

//节点类
class Node{
    //这里修饰符可以改为protected，方便上面的代码取值
    protected Node previous;//上一个节点地址
    protected Object obj;
    protected Node next;//下一个节点地址


    public Node() {

    }

    public Node(Node previous, Object obj, Node next) {
        this.previous = previous;
        this.obj = obj;
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}