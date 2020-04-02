package util;

import java.io.*;
import java.util.Arrays;
import static java.lang.Math.*;

/**
 * 文件操作工具类
 */
public class FileUtil {

    /**
     * 文件拷贝
     * @param src 源文件路径
     * @param dest 目标文件路径
     * @throws IOException
     */
    public static void copyFile(String src,String dest) throws IOException {
        //建立联系源（文件存在），建立目的地（文件可以不存在）
        copyFile(new File(src),new File(dest));
    }


    /**
     * 文件拷贝
     * @param src 源文件File对象
     * @param dest 目标文件File对象
     * @throws IOException
     */
    public static void copyFile(File src,File dest) throws IOException {
        if(!src.isFile()){//不是文件或为null
            System.out.println("只能拷贝文件");
            throw new IOException("只能拷贝文件");
        }
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

    /**
     * 文件夹的拷贝
     * 1、文件赋值copyFile
     * 2、文件创建mkdirs()
     * 3、递归查找子孙级
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        System.out.println(sin(PI/3));
        String[] s = {"阿里","尚学堂","京东","搜狐","网易"};
        System.out.println(Arrays.toString(s));

        String str="/Users/jiangzaohong/Documents/a.txt";
        String dest="/Users/jiangzaohong/Documents/2020032100009hh";
        try {
            copyFile(str,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        File src=new File(str);
//        File destfi=new File(dest);
//        copyFile(src,destfi);



    }
}
