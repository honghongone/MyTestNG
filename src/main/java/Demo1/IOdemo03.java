package Demo1;

import java.io.File;
import java.io.IOException;

/**
 * 相对路径和绝对路径构造File对象
 * 1：相对路径构造
 * File(String parent, String child) >>>>>File file=new File(parentPath,name);
 * File(File parent, String child)>>>>>>>>file=new File(new File(parentPath),name);
 * 2：绝对路径
 * File(String pathname)>>>>>>>>>> file=new File("/Users/jiangzaohong/Documents/2.jpg");
 */
public class IOdemo03 {
    //文件名
    public static void test1(){

        //绝对路径
        File file=new File("/Users/jiangzaohong/Documents/2.jpg");
        System.out.println(file.getName());//文件名字
        System.out.println(file.getPath());//文件路径，如果是绝对路径返回完整路径，否则返回相对路径
        System.out.println(file.getAbsolutePath());//返回绝对路径
        System.out.println(file.getParent());//返回上一级目录，如果是相对路径则返回为null

        file=new File("2.txt");
        System.out.println(file.getName());//文件名字
        System.out.println(file.getPath());//文件路径，如果是绝对路径返回完整路径，否则返回相对路径
        System.out.println(file.getAbsolutePath());//返回绝对路径
        System.out.println(file.getParent());//返回上一级目录，如果是相对路径则返回为null

    }

    //判断信息
    public static void test2(){
        String path="2.txt";
        File file=new File(path);
        System.out.println("文件是否存在："+file.exists());
        //windows路径是盘符开头认为是绝对路径，linux系统以/开头认为是绝对路径，其余就是相对路径
        System.out.println("是否是绝对路径："+file.isAbsolute());

        file=new File("/Users/jiangzaohong/Documents/1551e866-2c1e-4a12-8317-1e3266c012a4.jpg");
        System.out.println("文件是否存在："+file.exists());
        System.out.println("文件是否可写："+file.canWrite());
        System.out.println("文件是否可读:"+file.canRead());
        //注意一下如果文件不存在默认是当文件夹处理的
        System.out.println("是否是文件:"+file.isFile());
        System.out.println("是否是目录:"+file.isDirectory());
        System.out.println("是否是绝对路径："+file.isAbsolute());
        //file.length()文件字节数，不能读取文件夹的长度，只能读取文件的长度
        System.out.println("文件长度："+file.length());

    }

    //创建删除文件
    public static void test3() throws IOException, InterruptedException {
        String path="/Users/jiangzaohong/Documents/22.jpg";
        //createNewFile()文件不存在则创建新文件，存在则返回false
        File file=new File(path);
        if(!file.exists()){
            boolean flag=file.createNewFile();
            System.out.println(flag?"成功":"失败");
        }
        //删除文件
        boolean flag=file.delete();
        System.out.println(flag?"成功":"失败");

        //创建临时文件,createTempFile是静态方法
        File temp=File.createTempFile("teww",".temp",new File("/Users/jiangzaohong/Documents"));

        Thread.sleep(10000);//休息10秒

        temp.deleteOnExit();//程序退出就删除临时文件

    }

    public static void main(String[] args) {

        try {
            test3();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
