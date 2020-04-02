package Demo1;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * 5、操作目录
 * mkdir()创建目录，必须确保父目录存在，如果不存在，创建失败
 * mkdirs ()创建目录,如果父目录链不存在则一同创建
 * 1ist()文件1目录字符串形式
 * 1istFiles ()
 * static listRoots() 根路径
 *
 */
public class IOdemo04 {

    //创建目录
    public static void test1(){
        String path="/Users/jiangzaohong/Documents/py/test";
        File src=new File(path);
        //src.mkdir();
        src.mkdirs();
    }

    //遍历文件夹
    public static void test2(){
        String path="/Users/jiangzaohong/Documents/python";
        File file=new File(path);
        if(file.isDirectory()){
            System.out.println("子目录/文件名称");
            String[] subname=file.list();//返回该文件夹下的文件或目录名称数组
            for (String str:subname){
                System.out.println(str);
            }

            System.out.println("子目录/文件file对象");
            File[] files=file.listFiles();//返回该文件夹下的文件或目录的File对象
            for(File f:files){
                System.out.println(f.getAbsolutePath());
            }
        }
    }
    //找出文件夹下以.jpg结尾的文件
    public static void test3(){
        String path="/Users/jiangzaohong/Documents";
        File file=new File(path);
        //命令设计模式,FilenameFilter接口不能直接new所以这里是创建匿名对象，重写里面的accept方法
        //new File(dir,name).isFile()是文件，且name.endsWith(".java")文件名以.java结尾
        File[] files=file.listFiles(new FilenameFilter() {
            @Override
            //accept(File dir, String name)中dir代表自己即file，
            public boolean accept(File dir, String name) {
                return new File(dir,name).isFile()&&name.endsWith(".jpg");
            }
        });//通过这个匿名对象的accept方法返回的files就是包含所有以.java结尾的文件，然后遍历打印该文件的绝对路径即可
        for(File f:files){
            System.out.println(f.getAbsolutePath());
        }
    }

    //输出子孙级目录/文件的名称(绝对路径)，1：listFiles 2:递归
    public static void test4(){
        String path="/Users/jiangzaohong/Documents";
        File parent=new File(path);
        printName(parent);
    }

    //输出子孙级目录/文件的名称(绝对路径)，1：listFiles 2:递归
    public static void printName(File src){
        if(src==null||!src.exists()){
            return;
        }
        System.out.println(src.getAbsolutePath());
        if(src.isDirectory()){//如果是文件夹
            for(File sub:src.listFiles()){
                printName(sub);//递归打印名字
            }
        }

    }

    public static void test5(){
        File[] roots=File.listRoots();//返回跟路径，即windows是d:,e:，Linux是/
        System.out.println(Arrays.toString(roots));
        for(File file:roots){
            printName(file);//如果是windows就可以遍历输出所有盘符下的文件路径
        }
    }
    public static void main(String[] args) {
        test5();


    }
}
