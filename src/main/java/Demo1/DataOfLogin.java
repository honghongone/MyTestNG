package Demo1;

import org.testng.annotations.DataProvider;

public class DataOfLogin {

    @DataProvider
    public Object[][] getUsers(){
        return new Object[][]{
                {"zhangsan","123456","欢迎zhangsan"},
                {"lisi","","用户名或密码不能为空"},
                {"","","用户名或密码不能为空"},
                {"admin","123456","欢迎管理员"}
        };
    }
}
