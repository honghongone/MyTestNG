package Demo1;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcUtil {

    static Properties pro=null;

    static {//静态代码快在加载jdbcutil类的时候调用，只会调用一次
        pro=new Properties();
        try{
            pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));

        }catch (IOException e){
            e.printStackTrace();
        }

    }
//获取连接对象
    public static Connection getmycon(){
        try {
            Class.forName(pro.getProperty("driver"));
            return DriverManager.getConnection(pro.getProperty("testurl"),pro.getProperty("user_test"),pro.getProperty("password_test"));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
//关闭连接信息
    public static void close(ResultSet rs, Statement st,Connection co){

        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(st!=null){
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(co!=null){
                co.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close( Statement st,Connection co){

        try {
            if(st!=null){
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(co!=null){
                co.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close( Connection co){

        try {
            if(co!=null){
                co.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
