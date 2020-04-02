package Demo1;

import java.io.File;

/**
 * 看下File类里面的静态常量
 * 1：路径分割符
 * 2：名称/文件分割符（window是\,linux是/）
 */
public class IOdemo01 {
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);//1：路径分割符
        System.out.println(File.separator);//名称/文件分割符
        //路径表示方式，推荐使用
        String path="/Users/jiangzaohong/Documents/1551e866-2c1e-4a12-8317-1e3266c012a4.jpg";
        //如果是动态生成的推荐使用这种方式，一般不推荐使用
        path=File.separator+"Users"+File.separator+"jiangzaohong"+File.separator+"Documents"+File.separator+"1551e866-2c1e-4a12-8317-1e3266c012a4.jpg";
    }
}
