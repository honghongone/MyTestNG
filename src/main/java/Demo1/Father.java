package Demo1;

/**
 * 总结：
 * 要么子类和父类同时擦除，要么子类大于等于父类的类型，
 * 不能子类擦除，父类泛型
 * 1、属性类型，如父类中
 * 父类中，随父类而定
 * 子类中，随子类而定
 * 2、方法重写中的属性的类型:随父类而定
 *
 * @param <T>
 */
public abstract class Father<T> {
    T name;
    public abstract void test(T t);
}

//子类声明时指定具体类型，属性类型为具体类型，方法同理
//如这里的t就是随父类定义的
class Child extends Father<String>{
    int age;
    public  void test(String t){

    }
}

//子类为范型类，类型和个数必须和父类一样顺序可以不一样如父类是<T1,T2>子类只能是<T2,T1>或<T1,T2>
//子类为范型类，T类型在使用时确认
class Child2<T> extends Father<T>{
    public  void test(T t){

    }
}
//子类为范型类，父类不指定类型(范型的擦除)，也就是父类中的T变成了Object
class Child3<T> extends Father{
    T name2;//使用时确定类型
    public  void test(Object t){//可以看到这个的类型变成了Object，而不是父类方法中的T，如果写成T会报错

    }
}

//子类和父类同时范型擦除，这个时候代码中声明变量的时候不能是T i必须指定类型，同时可以看到重写的方法中的类型是Object
class Child4 extends Father{
    int i;//必须声明的时候指定类型
    public  void test(Object t){

    }
}
/*
//错误的用法，子类擦除，父类使用范型
class Child5 extends Father<T>{
    public  void test(T t){

    }
}
 */