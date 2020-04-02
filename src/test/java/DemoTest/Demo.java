package DemoTest;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Demo {
    @Test
    public void keyword(ITestContext context){
        context.setAttribute("demoString", "Test Passing Value.");
    }

    @Test
    public void keywordPass(ITestContext context){
        System.out.println(context.getAttribute("demoString"));
    }
}