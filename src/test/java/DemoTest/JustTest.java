package DemoTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JustTest {

    @Test
    public void test4(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test(dependsOnMethods = "test2")
    public void test3(){
        System.out.println("test3");

    }




    public static void main(String[] args) {
        Map map=new HashMap();
    }





}

