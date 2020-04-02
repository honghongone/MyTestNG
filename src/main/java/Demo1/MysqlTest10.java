package Demo1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

/**
 * 测试jdbcutil工具类来简化jdbc开发
 *
 *ResultSet resultSet = statement.executeQuery(sql);
 *             ResultSetMetaData metaData = resultSet.getMetaData();
 *             int count = metaData.getColumnCount();
 *             while (resultSet.next()){
 *                 Map<String,Object> result = new HashMap<>();
 *                 for(int i=1;i<=count;i++){
 *                     result.put(metaData.getColumnName(i),resultSet.getObject(i));
 *                 }
 */
public class MysqlTest10 {

    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet set=null;
        try {
           connection=jdbcUtil.getmycon();
           ps=connection.prepareStatement("select empname,salary,age,deptid from emp where id>?");
           ps.setInt(1,1);
           set=ps.executeQuery();
            ResultSetMetaData metaData = set.getMetaData();
            int count = metaData.getColumnCount();
            System.out.println(count);
            System.out.println(metaData.getColumnName(4));




        }  catch (Exception e) {
            e.printStackTrace();
        }  finally {
           jdbcUtil.close(ps,connection);
        }
    }
}
