package Demo1;

import java.sql.*;

/**
 * 测试批处理的基本用法
 */
public class MysqlTest4 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement stm=null;
        ResultSet set=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","123456");
            connection.setAutoCommit(false);//设置事务为手动提交
            long start=System.currentTimeMillis();
            stm=connection.createStatement();
            for(int i=0;i<20000;i++){
                stm.addBatch("insert into m_user(name,time) values ('高企"+i+"',now())");
            }//循环插入2万条数据
            stm.executeBatch();//执行
            connection.commit();//提交事务
            long end=System.currentTimeMillis();
            System.out.println("插入两万条数据耗时："+(end-start));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                connection.rollback();//如果出现异常就自动回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(set!=null){
                    set.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(stm!=null){
                    stm.close();
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
