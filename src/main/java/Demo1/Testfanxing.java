package Demo1;

/**
 * 接口中范型字母只能使用在方法中，不能使用在全局常量中
 * @param <T>
 */
public interface Testfanxing<T> {
    //T name=0;//可以看到这里会报错
    void test(T t);

}
