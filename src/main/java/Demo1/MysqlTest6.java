package Demo1;

import java.sql.*;
import java.util.Random;

/**
 * 测试时间处理（java.sql.Time,java.sql.Timestamp,java.sql.Date）
 */
public class MysqlTest6 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement prstm=null;
        PreparedStatement prstm2=null;
        ResultSet set=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","123456");

            for(int i=0;i<1000;i++){
                prstm=connection.prepareStatement("insert into m_user(name,time,timestamp,date) values (?,?,?,?)");

                prstm.setString(1,"qq"+i);
                prstm.setDate(2,new Date(System.currentTimeMillis()));

                int ram=100000000+new Random().nextInt(100000000);//设置一个随机数

                java.sql.Date date=new java.sql.Date(System.currentTimeMillis()-ram);
                Timestamp timestamp=new Timestamp(System.currentTimeMillis()-ram);
                prstm.setTimestamp(3,timestamp);
                prstm.setDate(4,date);
                prstm.execute();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
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
