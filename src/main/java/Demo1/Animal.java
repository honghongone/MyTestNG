package Demo1;

public class Animal {
     String str;
     public void voice(){
         System.out.println("animal");
     }

}

class Cat extends Animal{

    public void voice(){
        System.out.println("喵喵喵");
    }

    public void catchMouse(){
        System.out.println("捉老鼠");
    }
}

class Dog extends Animal{
    public void voice(){
        System.out.println("汪汪汪");
    }

    public void seeDoor(){
        System.out.println("看门");
    }
}

