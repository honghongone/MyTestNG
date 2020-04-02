package Demo1;

import java.io.*;

public class IOinputstremDemo1 {

    //将硬盘中的文件读取到程序中
    public static void test1(){
        //1：建立联系，创建File对象
        File src=new File("/Users/jiangzaohong/Documents/a.txt");
        //new FileInputStream("/Users/jiangzaohong/Documents/a.txt")也可以直接传字符串进去
        //因为FileInputStream有提供该构造方法，内部帮我们new File了
        //2:选择流
        InputStream in=null;
        try {
            in=new FileInputStream(src);
            //3：操作不断读取
            byte[] by=new byte[10];
            int len=0;
            while ((len=in.read(by))!=-1){
                //字节数组转成字符串
                String str=new String(by,0,len);
                System.out.print(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取失败");
        }
        finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//将程序中的字符串写到硬盘的文件中
    public static void test2(){
        File src=new File("/Users/jiangzaohong/Documents/2020032018.txt");
        OutputStream out=null;
        try {
            //new FileOutputStream(src,true);如果第二个参数是true表示以追加的形式往文件里面写内容，如果是false或不填则是覆盖的形式写入文件中
            out=new FileOutputStream(src,true);
            String str="helloppp\r\n";
            //字符串转字节数组
            byte[] by=str.getBytes();
            out.write(by,0,by.length);
            //输出流管道没有满的时候就会等待往里面写东西，只有满了才会把流的内容写到文件里面去，所以
            //我们要用flush方法将流强制刷出去
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件找不到");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写入失败");
        }finally {
            if(out!=null){
                try {
                    //输出流在关闭的时候会自动把输出流的东西写到文件里面去，但是我们也需要
                    //养成良好的习惯就是自己使用flush方法将流的东西刷出去
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        test2();
    }
}
