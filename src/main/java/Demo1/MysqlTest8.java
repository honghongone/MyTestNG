package Demo1;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 测试CLOB文本大对象的使用
 * 包含:将字符串、文件内容插入数据库中的CLOB字段、以及将数据库CLOB字段值取出来的操作
 *
 */
public class MysqlTest8 {


    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet set=null;
        Reader reader=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","123456");
            /*ps=connection.prepareStatement("insert into m_user(name,info) values (?,?)");
            ps.setString(1,"zaozao");
            //setClob(int parameterIndex, Reader reader)可以看到这个方法里面的第二个参数是一个流对象
            //将文本文件内容直接输入到数据库中
            //ps.setClob(2,new FileReader(new File("/Users/jiangzaohong/Documents/a.txt")));

            //也可以直接将字符串放到数据库中，但是这个放到的第二个参数必须是流，所以写法如下
            //即将程序中的字符串以流的形式输入到数据库的clob字段中
            //先转换成字节流ByteArrayInputStrea，再转换成字符流InputStreamReader
            ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaaaa".getBytes()))));
            ps.executeUpdate();*/

            //将数据库中的clob内容取出来
            ps=connection.prepareStatement("select * from m_user where id=?");
            ps.setInt(1,22023);
            set=ps.executeQuery();
            while(set.next()){
                    Clob clob=set.getClob("info");
                    reader=clob.getCharacterStream();
                    int temp=0;
                    while((temp=reader.read())!=-1){
                        System.out.print((char)temp);
                    }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {

            try {
                if(reader!=null){
                    reader.close();
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
