package CollectionDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试map的方法
 */
public class TestMap {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("张三",new Wife("张曼玉"));
        map.put("李四",new Wife("张柏芝"));
        System.out.println(map.get(1));

    }
}

class Wife{
    private String name;

    public Wife(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
