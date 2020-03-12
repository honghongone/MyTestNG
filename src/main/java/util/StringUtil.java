package util;

import java.util.*;

public class StringUtil {


    public static void test(String str)
    {
        int max_length = 0;
        String max_str = "";
        while (str.length() > 0)
        {
            System.out.println(str);
            int length = str.length();
            //取第一个字符
            String first = str.substring(0, 1);
            //去掉str里面所有的first字符
            str = str.replaceAll(first, "");
            //原来的字符长度-去掉后的字符长度 =去掉的所有字符的长度
            if (max_length < length - str.length())
            {
                max_length = length - str.length();
                max_str = first;
            }
        }
        System.out.println("");
        System.out.println("出现次数最多的字符:" + max_str + ";出现的次数:" + max_length);
    }

    public static void main(String[] args) {
        String str="你好hellohusdssddddhhhhhh";
        test(str);
        System.out.println(str);
        Set set1=new HashSet();
        set1.add(1);
        set1.add(2);
        System.out.println(set1);
        List list1=new ArrayList();
        list1.add(2);
        list1.add(4);
        System.out.println(list1);
        Map map1=new HashMap();
        map1.put("name","jzh");
        map1.put("age",12);
        System.out.println(map1);
        int[] arrery=new int[]{1,23,5};
        System.out.println(arrery);



    }
}
