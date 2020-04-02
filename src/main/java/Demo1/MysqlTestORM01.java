package Demo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试使用Object[]来封装一条记录
 * 使用List<Object[]>来封装多条记录
 *
 */
public class MysqlTestORM01 {

    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        //Object[] obs=new Object[3];
        List<Object[]> list=new ArrayList<Object[]>();
        try {
           connection=jdbcUtil.getmycon();
           ps=connection.prepareStatement("select empname,salary,age from emp where id>?");
           ps.setInt(1,1);
           rs=ps.executeQuery();
           while (rs.next()){
               Object[] obs=new Object[3];
               obs[0]=rs.getObject("empname");
               obs[1]=rs.getObject("salary");
               obs[2]=rs.getObject("age");
               list.add(obs);

           }

        }  catch (Exception e) {
            e.printStackTrace();
        }  finally {
           jdbcUtil.close(rs,ps,connection);
        }
        for(Object[] obs:list){
            System.out.println("result:"+obs[0]+obs[1]+obs[2]);

        }
    }
}
