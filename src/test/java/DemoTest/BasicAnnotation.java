package DemoTest;
import org.testng.annotations.*;
public class BasicAnnotation {

    @Test //最基本的注解，用来把方法标记为测试的一部分
    public void testCase1(){
        System.out.println("这个测试用例1");
    }

    @Test
    public void testCase2(){
        System.out.println("这个测试用例2");
    }
    @BeforeMethod
    public void beforMethod(){
        System.out.println("这是在测试前运行的beforemethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是在测试方法之后运行的after method");
    }

    @BeforeClass
    public void bedorClass(){
        System.out.println("这是类运行之前运行的方法before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("这是类运行后执行的方法 afterclass");
    }

    @BeforeTest
    public void beforetest(){
        System.out.println("beforetest");
    }

    @AfterTest
    public void aftertest(){
        System.out.println("after test");
    }

    @BeforeSuite
    public void beforesuit(){
        System.out.println("before suite");
    }

}