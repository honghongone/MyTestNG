package Demo1;

import java.sql.*;

/**
 * 测试事务的基本用法
 */
public class MysqlTest5 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement prstm=null;
        PreparedStatement prstm2=null;
        ResultSet set=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","123456");
            connection.setAutoCommit(false);//设置事务为手动提交,jdbc默认是true自动提交的

            prstm=connection.prepareStatement("insert into m_user(name,time) values (?,?)");
            prstm.setString(1,"qq");
            prstm.setDate(2,new Date(System.currentTimeMillis()));
            prstm.execute();

            Thread.sleep(6000);//为了看效果，让程序在这里休息6秒

            prstm2=connection.prepareStatement("insert into m_user(name,time) values (?,?,?)");
            prstm2.setString(1,"qq2");
            prstm2.setDate(2,new Date(System.currentTimeMillis()));
            prstm2.execute();

            connection.commit();//提交事务
            System.out.println("over");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
//            try {
//                connection.rollback();//如果出现异常就自动回滚
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if(set!=null){
                    set.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(prstm!=null){
                    prstm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(prstm2!=null){
                    prstm2.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
