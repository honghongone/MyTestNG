package DemoTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JustTest {

    @Test
    public void test(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(2,3);
    }
}
