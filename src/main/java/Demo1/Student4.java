package Demo1;

/**
 * ?使用在声明类型或声明方法中，不能声明类或使用的时候用
 * ?表示类型不定，使用的时候确定类型
 * ?extends:<=上限，指定类型为自身或子类
 * ?super:>=上限，指定类型为自身或父类
 * @param <T>
 */
public class Student4<T> {
    T score;

    public static void main(String[] args) {
        //?在声明变量类型时使用
        Student4<?> stu=new Student4<String>();
        test(new Student4<Integer>());
        test2(new Student4<Apple>() );//范型的多态
        //test3(new Student4<Apple>());//如果没有? extends则范型类就没有多态所以这里这样写是错误的
        test4(new Student4<Object>());
        test4(new Student4<Fruit>());

    }
    //?在声明方法中使用
    public static void test(Student4<?> stu){

    }

    public static void test2(Student4<? extends Fruit > stu){

    }

    public static void test3(Student4<Fruit > stu){

    }
//super使用
    public static void test4(Student4<? super Fruit > stu){

    }
}
