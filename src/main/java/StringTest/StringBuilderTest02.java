package StringTest;

/**
 * 测试stringbuilder常用的一些方法
 */
public class StringBuilderTest02 {
    public static void main(String[] args) {
        StringBuilder sb1=new StringBuilder("abcdefghijklmno");
        sb1.delete(2,4);//删除第2到第3位字符
        System.out.println(sb1);
        sb1.reverse();//将字符串反转
        System.out.println(sb1);
    }
}
