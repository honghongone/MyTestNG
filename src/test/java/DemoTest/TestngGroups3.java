package DemoTest;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestngGroups3 {
    @BeforeGroups(groups={"group-b"})
    public void setUp(){
        System.out.println("Method---setup");
    }

    @AfterGroups(groups={"group-b"})
    public void tearDown(){
        System.out.println("Method---tearDown");
    }

    @Test(groups = { "group-a" })
    public void aaaMethod() {
        System.out.println("Method---aaa");
    }

//    @BeforeGroups(groups={"group-a"})
//    public void setUp2(){
//        System.out.println("Method---setupaaa");
//    }

//    @AfterGroups(groups={"group-a"})
//    public void tearDown2(){
//        System.out.println("Method---tearDownaaa");
//    }

    @Test(groups = { "group-b"} )
    public void bbbMethod() {
        System.out.println("Method---bbb");
    }

//    @Test(groups = { "group-a","group-b" })
//    public void cccMethod() {
//        System.out.println("Method---ccc");
//    }
}
