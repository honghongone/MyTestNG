package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.InputStream;

public class ReadJson {
    public JSONObject read(String filename) {
        InputStream in = super.getClass().getClassLoader().getResourceAsStream(filename);
        JSONObject json=new JSONObject();
        StringBuffer bu=new StringBuffer();
        byte[] by=new byte[10];
        int len=-1;
        try{
            while((len=in.read(by))!=-1){
                  String str=new String(by,0,len);
                  bu.append(str);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                in.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        String str=bu.toString();
        System.out.println(str);
        json= JSON.parseObject(str);
        return json;

    }

    public static void main(String[] args) {
        ReadJson j=new ReadJson();
        JSONObject jsonObject=j.read("test.json");
        System.out.println(jsonObject);
        System.out.println(jsonObject.getString("one"));
        System.out.println(jsonObject.getIntValue("test"));


    }
}

