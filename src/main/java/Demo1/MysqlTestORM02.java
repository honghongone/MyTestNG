package Demo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.sql.ResultSetMetaData;
/**
 * 测试使用map来封装一条记录
 * 使用List<map>来封装多条记录
 * 使用Map<String,Map>来封装多条记录
 *
 */
public class MysqlTestORM02 {


    public static void test03(){
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        try {
            connection=jdbcUtil.getmycon();
            ps=connection.prepareStatement("select empname,salary,age from emp where id>?");
            ps.setInt(1,1);
            rs=ps.executeQuery();
            while (rs.next()){
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("empname",rs.getObject(1));
                map.put("salary",rs.getObject(2));
                map.put("age",rs.getObject(3));
                list.add(map);

            }

        }  catch (Exception e) {
            e.printStackTrace();
        }  finally {
            jdbcUtil.close(rs,ps,connection);
        }
        for(Map<String,Object> map:list){
            for(String key:map.keySet()){
                System.out.print(key+"--"+map.get(key)+"\t");
            }
            System.out.println();
        }

    }

    public static void test02(){
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Map<String,Map<String,Object>> mapHashMap=new HashMap<String,Map<String,Object>>();
        try {
            connection=jdbcUtil.getmycon();
            ps=connection.prepareStatement("select empname,salary,age from emp where id>?");
            ps.setInt(1,1);
            rs=ps.executeQuery();
            while (rs.next()){
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("empname",rs.getObject(1));
                map.put("salary",rs.getObject(2));
                map.put("age",rs.getObject(3));
                mapHashMap.put(rs.getString(1),map);

            }

        }  catch (Exception e) {
            e.printStackTrace();
        }  finally {
            jdbcUtil.close(rs,ps,connection);
        }
        for(String key1:mapHashMap.keySet()){
            for(String key:mapHashMap.get(key1).keySet()){
                System.out.print(key+"--"+mapHashMap.get(key1).get(key)+"\t");
            }
            System.out.println();
        }
    }

    public static void test04(){
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        try {
            connection=jdbcUtil.getmycon();
            ps=connection.prepareStatement("select empname,salary,age from emp where id>?");
            ps.setInt(1,1);
            rs=ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int count=metaData.getColumnCount();
            while (rs.next()){
                Map<String,Object> map=new HashMap<String,Object>();
              for(int i=1;i<=count;i++){
             map.put(metaData.getColumnName(i),rs.getObject(i));
              }
              list.add(map);
            }

        }  catch (Exception e) {
            e.printStackTrace();
        }  finally {
            jdbcUtil.close(rs,ps,connection);
        }
        for(Map<String,Object> map:list){
            for(String key:map.keySet()){
                System.out.print(key+"--"+map.get(key)+"\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
       test04();

    }
}
