package Demo1;

/**
 * 范型接口与继承问题
 * 重写方法中的属性类型随父类而定
 * @param <T>
 */
public interface Testfan<T> {
    void compare(T t);
}
//声明子类指定具体类型
class com implements Testfan<String>{

    @Override
    public void compare(String s) {

    }
}
//父类和子类都擦除
class com1 implements Testfan{

    @Override
    public void compare(Object o) {

    }
}
//父类和子类都范型
class com2<T> implements Testfan<T>{

    @Override
    public void compare(T t) {

    }
}
//父类擦除，子类范型
class com3<T> implements Testfan{

    @Override
    public void compare(Object o) {

    }
}
//子类擦除，父类范型是错误
/*
class com4 implements Testfan<T>{

    @Override
    public void compare(T t) {

    }
}*/
