package Demo1;

import java.io.File;

/**
 * 相对路径和绝对路径构造File对象
 * 1：相对路径构造
 * File(String parent, String child) >>>>>File file=new File(parentPath,name);
 * File(File parent, String child)>>>>>>>>file=new File(new File(parentPath),name);
 * 2：绝对路径
 * File(String pathname)>>>>>>>>>> file=new File("/Users/jiangzaohong/Documents/2.jpg");
 */
public class IOdemo02 {
    public static void main(String[] args) {
        String parentPath="/Users/jiangzaohong/Documents";
        String name="2.jpg";
        //相对路径
        File file=new File(parentPath,name);
        file=new File(new File(parentPath),name);
        System.out.println(file.getName());//文件名字
        System.out.println(file.getPath());//文件路径
        //绝对路径
        file=new File("/Users/jiangzaohong/Documents/2.jpg");
        System.out.println(file.getName());//文件名字
        System.out.println(file.getPath());//文件路径
        //没有盘符，以user.dir来构建
        //可以看到如果只有文件名，则是以当前工程所在路径构建的
        ///Users/jiangzaohong/IdeaProjects/myAutoTest/MyTestNG/test.txt
        file=new File("test.txt");
        System.out.println(file.getName());//文件名字
        System.out.println(file.getPath());//文件路径
        System.out.println(file.getAbsolutePath());

        file=new File(".");
        System.out.println(file.getName());//文件名字
        System.out.println(file.getPath());//文件路径
        System.out.println(file.getAbsolutePath());

     }
}
