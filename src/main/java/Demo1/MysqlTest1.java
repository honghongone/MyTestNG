package Demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试执行sql以及sql注入问题
 */
public class MysqlTest1 {
    public static void main(String[] args) {

        try {
            //第一步加载驱动类,作用就是将这个类加载到内存中
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","123456");
            Statement statement=connection.createStatement();
//            String name="zaozao";
//            String sql="INSERT into m_user (name,time) VALUES('"+name+"',NOW())";
//但是String id="1";里面的1是外部传进来的，有可能传入恶意的操作，如1 or 2=2;这样就导致数据被全部删完了
            String id="3 or 2=2";
            String sql="delete from m_user where id="+id;
            statement.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
