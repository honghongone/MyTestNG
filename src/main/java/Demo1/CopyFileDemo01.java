package Demo1;

import java.io.*;

/**
 * 文件拷贝
 */
public class CopyFileDemo01 {

    //文件拷贝
    public static void test1(){
        //建立联系源（文件存在），建立目的地（文件可以不存在）
        File src=new File("/Users/jiangzaohong/Documents/a.txt");
        File dest=new File("/Users/jiangzaohong/Documents/20200321.txt");
        //选择流
        InputStream in=null;
        OutputStream out=null;
        try {
            in=new FileInputStream(src);
            out=new FileOutputStream(dest);
            byte[] by=new byte[10];
            int len=0;
            while ((len=in.read(by))!=-1){
                out.write(by,0,len);
            }
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test1();
    }
}
