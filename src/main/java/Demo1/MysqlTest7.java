package Demo1;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 测试时间处理（java.sql.Time,java.sql.Timestamp,java.sql.Date）,取出指定时间段的数据
 */
public class MysqlTest7 {

    //将string类型的时间转换为long类型，格式为yyyy-MM-dd hh:mm:ss
    public static long str2long(String str){
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet set=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","123456");
//            ps=connection.prepareStatement("select * from m_user where date>? and date<?");
//            java.sql.Date start=new Date(str2long("2020-3-15 10:10:10"));
//            java.sql.Date end=new Date(str2long("2020-3-17 10:10:10"));
//            ps.setDate(1,start);
//            ps.setDate(2,end);

            ps=connection.prepareStatement("select * from m_user where timestamp>? and timestamp<? order by timestamp");
            Timestamp start=new Timestamp(str2long("2020-3-17 10:10:20"));
            Timestamp end=new Timestamp(str2long("2020-3-17 17:10:20"));
            ps.setObject(1,start);
            ps.setObject(2,end);
            set=ps.executeQuery();
            while(set.next()){
                System.out.println(set.getObject("id")+"--"+set.getObject("timestamp")+"---"+set.getObject("date"));
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
                if(ps!=null){
                    ps.close();
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
