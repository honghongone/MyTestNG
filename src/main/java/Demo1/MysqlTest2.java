package Demo1;

import java.sql.*;

/**
 * 测试PreparedStatement的基本用法
 */
public class MysqlTest2 {
    public static void main(String[] args) {

        try {
            //第一步加载驱动类,作用就是将这个类加载到内存中
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","123456");
            String sql="insert into m_user(name,time) values (?,?)";//？是占位符
            PreparedStatement pres=connection.prepareStatement(sql);
            pres.setString(1,"hello2");//索引是从1开始的而不是从0开始
            pres.setDate(2,new Date(System.currentTimeMillis()));//这里的date是java.sql里面的类
            //pres.execute();
            int count=pres.executeUpdate();
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
