package DemoTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Demo1.Login;
import Demo1.DataOfLogin;


public class LoginTest {



    @Test(dataProvider="getUsers",dataProviderClass =DataOfLogin.class )
    public void demo1(String name1, String pwd1, String expect1){
            Login login = new Login();
            String result = login.userLogin(name1,pwd1);
            Assert.assertEquals(result,expect1);
        }

}

