package Demo1;

import java.sql.*;

/**
 * 测试ResultSet结果集的基本用法
 */
public class MysqlTest3 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement st=null;
        ResultSet set=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","123456");

            String sql="select * from m_user where id>?";
            st=connection.prepareStatement(sql);
            st.setInt(1,9);//设置sql语句中的id为大于9，第一个参数1表示索引位置1，第二个参数表示占位符的值
            set=st.executeQuery();//执行sql语句，executeQuery方法返回的是ResultSet类型的

            while(set.next()){//next方法类似一个游标，如果有下一个元素则返回true，同时游标下移一位，如果没有下一个元素返回false
                //System.out.println(set.getInt(1)+"---"+set.getString(2)+"--"+set.getDate(3));
                //getObject方法也可以
                System.out.println(set.getObject(1)+"---"+set.getObject(2)+"---"+set.getObject(3));
            }//set.getInt(1)表示取出结果集中第一列的元素，1表示索引，值为id是int类型所以用getInt
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
                if(st!=null){
                    st.close();
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
