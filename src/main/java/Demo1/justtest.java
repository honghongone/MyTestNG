package Demo1;

import org.testng.annotations.*;
import java.util.Iterator;
import java.lang.reflect.Method;
public class justtest {

    @DataProvider(name = "dp")
    public Object[][] createData(Method m) {
        System.out.println(m.getName());  // print test method name
        return new Object[][] { new Object[] { "Cedric" }};
    }

    @Test(dataProvider = "dp")
    public void test1(String s) {
        System.out.println("1:"+s);
    }

    @Test(dataProvider = "dp")
    public void test2(String s) {
        System.out.println("2"+s);
    }
}
