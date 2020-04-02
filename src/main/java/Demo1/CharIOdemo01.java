package Demo1;

import java.io.*;

/**
 * 纯文本文件读取和写入
 */
public class CharIOdemo01 {

    //读取纯文本文件
    public static void test1(){
        //建立联系，即创建源
        File file=new File("/Users/jiangzaohong/Documents/a.txt");
        Reader reader=null;
        //选择流
        try {
            reader=new FileReader(file);
            char[] chars=new char[10];
            int len=0;
            while ((len=reader.read(chars))!=-1){
                String str=new String(chars,0,len);
                System.out.print(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //写数据到文本文件中
    public static void test2(){
        //创建连接
        File src=new File("/Users/jiangzaohong/Documents/2020320.txt");
        //选择流
        Writer writer=null;
        String str="hellonihao";
        try {
            //writer=new FileWriter(src,true);表示追加，如果是false或者不写就是覆盖
            writer=new FileWriter(src);
            writer.write(str);
            writer.append("hehe");
            writer.flush();//强制将输出流的数据刷出到文件中
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //纯文本拷贝
    public static void test3(){

    }

    public static void main(String[] args) {
        test2();
    }
}
