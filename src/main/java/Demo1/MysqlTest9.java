package Demo1;

import java.io.*;
import java.sql.*;

/**
 * 测试BLOB二进制大对象的使用
 *
 *
 */
public class MysqlTest9 {


    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet set=null;
        InputStream in=null;
        OutputStream out=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","123456");
            /*ps=connection.prepareStatement("insert into m_user(name,headimag) values (?,?)");
            ps.setString(1,"zaozao2");
            //将图片内容直接输入到数据库中
            ps.setBlob(2,new FileInputStream("/Users/jiangzaohong/Documents/1551e866-2c1e-4a12-8317-1e3266c012a4.jpg"));
            ps.execute();*/

            //将数据库中的blob内容取出来存到本地硬盘中
            ps=connection.prepareStatement("select * from m_user where id=?");
            ps.setInt(1,22024);
            set=ps.executeQuery();
            while(set.next()){
                Blob blob=set.getBlob("headimag");
               in=blob.getBinaryStream();
               out=new FileOutputStream("/Users/jiangzaohong/Documents/test0319.jpg");
               int temp=0;
               while ((temp=in.read())!=-1){
                   out.write(temp);
               }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                if(out!=null){
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if(in!=null){
                    in.close();
                }
            } catch (Exception e) {
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
