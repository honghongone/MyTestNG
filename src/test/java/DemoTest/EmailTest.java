package DemoTest;

import Demo1.Email;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmailTest {
    Email email;

    @BeforeClass
    public void beforeClass(){
        email=new Email();
    }

    @Epic("正向epic")
    @Story("正向story")
    @Step("通过DataProvider注入三组不同的数据，验证生成邮箱为数据@testfan.com")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider ="emaildemo",description = "邮箱生成的正向测试用例" )
    public void testGenerateEmail(String input,String emailex){
        Assert.assertEquals(email.generrateEmail(input),emailex);

    }

    @Epic("反向epic")
    @Story("反向story")
    @Step("输入null验证邮箱生成器")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "邮箱生成的反向测试用例" )
    public void testGenerateEmailException(String input,String emailex){
        // Assert.assertEquals(application.generrateEmail(input),email);
        String result=email.generrateEmail(null);

    }


    @DataProvider(name="emaildemo")
    public Object[][] generateEmail(){
        return new Object[][]{{"fan","fan@testfan.com"},{"qq","qq@testfan.com"},{"jzh","jzh@testfan.com"}};
    }
}
