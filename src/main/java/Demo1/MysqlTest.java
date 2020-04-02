package Demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试跟数据库建立连接
 */
public class MysqlTest {
    public static void main(String[] args) {
        //第一步加载驱动类,作用就是将这个类加载到内存中
        try {
            Class.forName("com.mysql.jdbc.Driver");
            long start=System.currentTimeMillis();
            //第二步：建立连接，DriverManager.getConnection帮我们返回一个Connection对象
            //(connection连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时!这是Connection对象管理的一个要点)
            //真正开发中，为了提高效率都会使用连接池来管理连接对象
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","123456");
            long end=System.currentTimeMillis();
            //可以看到打印结果是com.mysql.jdbc.JDBC4Connection@29ca901e，说明实现类是JDBC4Connection
            System.out.println(connection);
            System.out.println("建立连接耗时："+(end-start)+"ms毫秒");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
